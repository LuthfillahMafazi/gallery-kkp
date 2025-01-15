package com.example.gallerymuslim.presentation.addproduct

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
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isNotEmpty
import androidx.fragment.app.viewModels
import com.example.gallerymuslim.R
import com.example.gallerymuslim.databinding.FragmentAddProductBinding
import com.example.gallerymuslim.entities.GalleryEntities
import dagger.hilt.android.AndroidEntryPoint
import java.io.ByteArrayOutputStream
import java.io.InputStream

@AndroidEntryPoint
class AddProductFragment : Fragment() {
    private var _binding: FragmentAddProductBinding? = null
    private val binding get() = _binding

    private var spinnerColor: String? = null
    private var image: String? = null

    private val viewModel: AddProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddProductBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
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
                    etProductType.text.clear()
                    etProductName.text.clear()
                    etProductStock.text.clear()
                    etProductSize.text.clear()
                    etProductDesc.text.clear()
                    ivProductImage.setImageURI(null)
                    viewModel.addProduct(galleryEntities)
                    Toast.makeText(requireContext(), "Success add Product", Toast.LENGTH_SHORT).show()
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

    private fun initView() {
        binding?.apply {
            initSpinner()
        }
    }

    private fun initSpinner() {
        val colors = resources.getStringArray(R.array.product_colors)

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            colors
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding?.spinnerProductColor?.adapter = adapter

        binding?.spinnerProductColor?.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    val selectedColor = parent.getItemAtPosition(position).toString()
                    spinnerColor = selectedColor
                    Toast.makeText(requireContext(), "Selected: $spinnerColor", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
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
}