package com.example.a4aprojetahratina.Domain.usercase

import com.example.a4aprojetahratina.Data.Repository.UserRepository
import com.example.a4aprojetahratina.Domain.entity.User

class GetUserUseCase (
    private val userRepository: UserRepository
) {
    suspend fun invoke (email: String): User? {
       return userRepository.getUser(email)
    }
}