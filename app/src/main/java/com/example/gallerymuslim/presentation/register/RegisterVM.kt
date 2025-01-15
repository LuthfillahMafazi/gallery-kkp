package com.example.gallerymuslim.presentation.register

import android.util.Log
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gallerymuslim.entities.RegisterEntities
import com.example.gallerymuslim.usecase.register.IRegisterUseCase
import com.example.gallerymuslim.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterVM @Inject constructor(
    private val iRegisterUseCase: IRegisterUseCase
) : ViewModel(), androidx.databinding.Observable {


    var userDetailsLiveData = MutableLiveData<Array<RegisterEntities>>()

    @Bindable
    val inputFirstName = MutableLiveData<String?>()

    @Bindable
    val inputLastName = MutableLiveData<String?>()

    @Bindable
    val inputUsername = MutableLiveData<String?>()

    @Bindable
    val inputPassword = MutableLiveData<String?>()

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    private val _navigateto = MutableLiveData<Boolean>()

    val navigateto: LiveData<Boolean>
        get() = _navigateto

    private val _errorToast = MutableLiveData<Boolean>()

    val errotoast: LiveData<Boolean>
        get() = _errorToast

    private val _errorToastUsername = MutableLiveData<Boolean>()

    val errotoastUsername: LiveData<Boolean>
        get() = _errorToastUsername


    fun sumbitButton() {
        Log.i("MYTAG", "Inside SUBMIT BUTTON")
        if (inputFirstName.value == null || inputLastName.value == null || inputUsername.value == null || inputPassword.value == null) {
            _errorToast.value = true
        } else {
            uiScope.launch {
//            withContext(Dispatchers.IO) {
                iRegisterUseCase.getUserName(inputUsername.value!!).collect {
                    when (it) {
                        is Resource.Success -> {
                            Log.i("MYTAG", it.data?.userName.toString() + "------------------")
                            if (it.data != null) {
                                _errorToastUsername.value = true
                                Log.i("MYTAG", "Inside if Not null")
                            } else {
                                Log.i("MYTAG", userDetailsLiveData.value.toString() + "ASDFASDFASDFASDF")
                                Log.i("MYTAG", "OK im in")
                                val firstName = inputFirstName.value!!
                                val lastName = inputLastName.value!!
                                val email = inputUsername.value!!
                                val password = inputPassword.value!!
                                Log.i("MYTAG", "insidi Sumbit")
                                insert(
                                    RegisterEntities(
                                        firstName = firstName,
                                        lastName = lastName,
                                        userName = email,
                                        password = password
                                    )
                                )
                                inputFirstName.value = null
                                inputLastName.value = null
                                inputUsername.value = null
                                inputPassword.value = null
                                _navigateto.value = true
                            }
                        }

                        else -> Unit
                    }
                }
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
    }

    fun doneNavigating() {
        _navigateto.value = false
        Log.i("MYTAG", "Done navigating ")
    }

    fun donetoast() {
        _errorToast.value = false
        Log.i("MYTAG", "Done taoasting ")
    }

    fun donetoastUserName() {
        _errorToast.value = false
        Log.i("MYTAG", "Done taoasting  username")
    }

    private fun insert(user: RegisterEntities): Job = viewModelScope.launch {
        iRegisterUseCase.registerUser(user)
    }

    override fun removeOnPropertyChangedCallback(callback: androidx.databinding.Observable.OnPropertyChangedCallback) {

    }

    override fun addOnPropertyChangedCallback(callback: androidx.databinding.Observable.OnPropertyChangedCallback?) {

    }
}