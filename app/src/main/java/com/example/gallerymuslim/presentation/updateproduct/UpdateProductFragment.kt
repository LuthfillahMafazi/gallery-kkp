package com.example.gallerymuslim.presentation.updateproduct

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isNotEmpty
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gallerymuslim.databinding.FragmentUpdateProductBinding
import com.example.gallerymuslim.entities.GalleryEntities
import com.example.gallerymuslim.vo.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.io.InputStream

@AndroidEntryPoint
class UpdateProductFragment : Fragment() {
    private var _binding: FragmentUpdateProductBinding? = null
    private val binding get() = _binding

    private var spinnerColor: String? = null
    private var image: String? = null

    private val viewModel: UpdateProductViewModel by viewModels()
    private val args by navArgs<UpdateProductFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateProductBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeDetail()
        initListener()
    }

    private fun initListener() {
        binding?.apply {
            btnSelectImage.setOnClickListener {
                openGallery()
            }

            btnSubmit.setOnClickListener {
                val galleryEntities = GalleryEntities(
                    productType = etProductType.text.toString(),
                    productName = etProductName.text.toString(),
                    productStock = etProductStock.text.toString().toInt(),
                    productSize = etProductSize.text.toString(),
                    productColor = spinnerColor,
                    productImage = image,
                    productDesc = etProductDesc.text.toString()
                )
                if (validateAllFields()) {
                    viewModel.updateProduct(galleryEntities)
                    Toast.makeText(requireContext(), "Success update", Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()
                }
                else Toast.makeText(requireContext(), "Please fill all field", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateAllFields(): Boolean {
        binding?.apply {
            if (etProductType.text.isNotEmpty() && etProductName.text.isNotEmpty() && etProductStock.text.isNotEmpty() && etProductSize.text.isNotEmpty() && spinnerProductColor.isNotEmpty() && !spinnerColor.isNullOrEmpty() && image != null) {
                return true
            }
        }
        return false
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        galleryLauncher.launch(intent)
    }

    private val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK && result.data != null) {
                val selectedImageUri: Uri? = result.data?.data
                if (selectedImageUri != null) {
                    image = uriToBase64(selectedImageUri)
                    binding?.ivProductImage?.setImageURI(selectedImageUri)
                }
            }
        }

    private fun uriToBase64(uri: Uri): String {
        val inputStream: InputStream? = activity?.contentResolver?.openInputStream(uri)
        val bitmap = BitmapFactory.decodeStream(inputStream)
        inputStream?.close()

        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()

        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }

    private fun observeDetail() {
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
            etId.setText(data?.id.toString())
            etProductStock.setText(data?.productStock.toString())
            etProductDesc.setText(data?.productDesc)
            etProductName.setText(data?.productName)
            etProductSize.setText(data?.productSize)
            etProductType.setText(data?.productType)
            ivProductImage.setImageBitmap(displayImageFromString(data?.productImage))
        }
    }

    private fun displayImageFromString(base64String: String?) : Bitmap {
        val decodedString: ByteArray = Base64.decode(base64String, Base64.DEFAULT)
        val bitmap: Bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)

        return bitmap
    }
}