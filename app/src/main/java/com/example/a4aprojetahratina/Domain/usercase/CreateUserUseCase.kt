package com.example.a4aprojetahratina.Domain.usercase



class CreateUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(user : User){
    userRepository.createUser(user)
    }
}