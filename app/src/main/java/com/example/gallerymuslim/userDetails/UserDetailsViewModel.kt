package com.example.gallerymuslim.userDetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gallerymuslim.usecase.home.IHomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val iHomeUseCase: IHomeUseCase
) : ViewModel() {

    val users = iHomeUseCase.getAllUser()
    init {
        Log.i("MYTAG","inside_users_Lisrt_init")
    }

    private val _navigateto = MutableLiveData<Boolean>()

    val navigateto: LiveData<Boolean>
        get() = _navigateto

    fun doneNavigating(){
        _navigateto.value=false
    }

    fun backButtonclicked(){
        _navigateto.value = true
    }

}