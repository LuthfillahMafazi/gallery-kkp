package com.example.gallerymuslim.userDetails

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gallerymuslim.register.RegisterRepository
import java.lang.IllegalArgumentException

class UserDetalisFactory (
    private  var repository: RegisterRepository,
    private var application: Application
): ViewModelProvider.Factory{
    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserDetailsViewModel::class.java)) {
            return UserDetailsViewModel(repository, application) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}