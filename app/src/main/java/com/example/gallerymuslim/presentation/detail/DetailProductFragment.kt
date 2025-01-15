package com.example.gallerymuslim.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gallerymuslim.databinding.FragmentDetailProductBinding
import com.example.gallerymuslim.entities.GalleryEntities
import com.example.gallerymuslim.vo.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailProductFragment : Fragment() {
    private var _binding: FragmentDetailProductBinding? = null
    private val binding get() = _binding

    private val viewModel: DetailProductViewModel by viewModels()
    private val args by navArgs<DetailProductFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailProductBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeData()
        initListener()
    }

    private fun initListener() {
        binding?.btnUpdate?.setOnClickListener {
            findNavController().navigate(DetailProductFragmentDirections.actionDetailProductFragmentToUpdateProductFragment(args.idProduct))
        }
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getDetailProduct(args.idProduct).collect {
                when (it) {
                    is Resource.Success -> {
                        initView(it.data)
                    }

                    else -> Unit
                }
            }
        }
    }

    private fun initView(data: GalleryEntities?) {
        binding?.apply {
            valueId.text = data?.id.toString()
            valueProductType.text = data?.productType
            valueProductName.text = data?.productName
            valueProductStock.text = data?.productStock.toString()
            valueProductSize.text = data?.productSize
            valueProductColor.text = data?.productColor
            valueProductDesc.text = data?.productDesc
        }
    }
}