package com.example.gallerymuslim.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.gallerymuslim.module.RegisterDatabase
import com.example.gallerymuslim.R
import com.example.gallerymuslim.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var registerViewModel: RegisterVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentRegisterBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_register, container, false
        )

        val application = requireNotNull(this.activity).application
        val dao = RegisterDatabase.getInstance(application).registerDatabase
        val repository = RegisterRepository(dao)
        val factory = RegisterVMFactory(repository, application)

        registerViewModel = ViewModelProvider(this, factory)[RegisterVM::class.java]
        binding.myViewModel = registerViewModel
        this.also { binding.lifecycleOwner = it }
        registerViewModel.navigateto.observe(viewLifecycleOwner) { hasFinished ->
            if (hasFinished == true) {
                displayUsersList()
                registerViewModel.doneNavigating()
            }
        }

        registerViewModel.userDetailsLiveData.observe(viewLifecycleOwner) {
            Log.i("MYTAG", it.toString() + "000000000000000000000000")
        }


        registerViewModel.errotoast.observe(viewLifecycleOwner) { hasError ->
            if (hasError == true) {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT)
                    .show()
                registerViewModel.donetoast()
            }
        }

        activity?.let {
            registerViewModel.errotoastUsername.observe(it) { hasError ->
                if (hasError == true) {
                    Toast.makeText(requireContext(), "UserName Already taken", Toast.LENGTH_SHORT)
                        .show()
                    registerViewModel.donetoastUserName()
                }
            }
        }

        return binding.root
    }

    private fun displayUsersList() {
        val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }
}