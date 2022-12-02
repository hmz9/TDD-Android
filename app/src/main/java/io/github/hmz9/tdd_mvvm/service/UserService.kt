package io.github.hmz9.tdd_mvvm.service

import io.github.hmz9.tdd_mvvm.models.LOGIN_STATUS
import io.github.hmz9.tdd_mvvm.repository.UserRepository

class UserService(private val userRepository: UserRepository) {

    fun loginUser(email: String, password: String): String {
        val status = userRepository.loginUser(email, password)
        return when(status){
            LOGIN_STATUS.INVALID_USER -> "User does not exist"
            LOGIN_STATUS.INVALID_PASSWORD -> "Password is invalid"
            LOGIN_STATUS.UNKNOWN_ERROR -> "Unknown error occurred"
            LOGIN_STATUS.SUCCESS -> "Logged in successfully"
        }

    }
}