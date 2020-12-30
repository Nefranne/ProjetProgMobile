package com.example.a4aprojetahratina.Presentation.Main

sealed class LoginStatus

    data class LoginSuccess(val email: String) : LoginStatus()
    object LoginError : LoginStatus()

