package com.example.a4aprojetahratina.domain.usecase

import com.example.a4aprojetahratina.Data.Repository.UserRepository
import com.example.a4aprojetahratina.Domain.entity.User
import com.example.a4aprojetahratina.Domain.usercase.CreateUserUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUserUseCaseTest {
    private val userRepository: UserRepository = mockk()

    private val classUnderTest = CreateUserUseCase(userRepository)

    @Test
    fun resendMailSuccess(){
        runBlocking {
            val user =User("")
            coEvery{userRepository.createUser(user)} returns Unit
            classUnderTest.invoke(user)
            coVerify(exactly=1){
                userRepository.createUser(user)
            }
        }

    }

}