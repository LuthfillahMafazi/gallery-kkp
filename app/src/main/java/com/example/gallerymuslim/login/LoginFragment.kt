package com.example.gallerymuslim.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.gallerymuslim.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding : FragmentLoginBinding? =null
    private val binding get() = _binding
    private val loginViewModel: LoginVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding?.myLoginViewModel = loginViewModel

        binding?.lifecycleOwner = this

        loginViewModel.navigatetoRegister.observe(viewLifecycleOwner) { hasFinished ->
            if (hasFinished == true) {
                Log.i("MYTAG", "insidi observe")
                displayUsersList()
                loginViewModel.doneNavigatingRegiter()
            }
        }

        loginViewModel.errotoast.observe(viewLifecycleOwner) { hasError ->
            if (hasError == true) {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT)
                    .show()
                loginViewModel.donetoast()
            }
        }

        loginViewModel.errotoastUsername .observe(viewLifecycleOwner) { hasError ->
            if (hasError == true) {
                Toast.makeText(
                    requireContext(),
                    "User doesnt exist,please Register!",
                    Toast.LENGTH_SHORT
                ).show()
                loginViewModel.donetoastErrorUsername()
            }
        }

        loginViewModel.errorToastInvalidPassword.observe(viewLifecycleOwner) { hasError ->
            if (hasError == true) {
                Toast.makeText(requireContext(), "Please check your Password", Toast.LENGTH_SHORT)
                    .show()
                loginViewModel.donetoastInvalidPassword()
            }
        }

        loginViewModel.navigatetoUserDetails.observe(viewLifecycleOwner) { hasFinished ->
            if (hasFinished == true) {
                Log.i("MYTAG", "insidi observe")
                navigateUserDetails()
                loginViewModel.doneNavigatingUserDetails()
            }
        }


        return binding?.root
    }


    private fun displayUsersList() {
        Log.i("MYTAG","insidisplayUsersList")
        val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
        NavHostFragment.findNavController(this).navigate(action)

    }

    private fun navigateUserDetails() {
        Log.i("MYTAG","insidisplayUsersList")
        val action = LoginFragmentDirections.actionLoginFragmentToUserDetailsFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }
}