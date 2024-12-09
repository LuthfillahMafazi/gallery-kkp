package com.example.gallerymuslim.register

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class RegisterVMFactory(
    private var repository: RegisterRepository,
    private var application: Application
) : ViewModelProvider.Factory {
    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterVM::class.java)) {
            return RegisterVM(repository, application) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}