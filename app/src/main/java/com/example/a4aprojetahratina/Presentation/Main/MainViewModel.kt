package com.example.a4aprojetahratina.Presentation.Main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a4aprojetahratina.Domain.entity.User
import com.example.a4aprojetahratina.Domain.usercase.CreateUserUseCase
import com.example.a4aprojetahratina.Domain.usercase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.sql.Types.NULL

class MainViewModel(
        private val createUserUseCase: CreateUserUseCase,
        private val getUserUseCase: GetUserUseCase
): ViewModel() {

    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()
    fun onClickedLogin (emailUser: String, password: String) {
        viewModelScope.launch (Dispatchers.IO) {
            getUserUseCase.invoke(emailUser)
            createUserUseCase.invoke(User("test"))
            val user : User? = getUserUseCase.invoke(("test"))
            val loginStatus: LoginStatus = if (user != null){
            LoginSuccess(user.email)
            }
            else {
                LoginError
            }
            withContext(Dispatchers.Main) {
                loginLiveData.value = loginStatus
            }
        }
    }


}