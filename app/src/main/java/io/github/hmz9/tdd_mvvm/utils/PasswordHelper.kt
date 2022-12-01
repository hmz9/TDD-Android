package io.github.hmz9.tdd_mvvm.utils

class PasswordHelper {

    fun isPasswordValid(password: String): Boolean {
        var result = true

        if(password.length !in 6..15){
            result = false
        }

        return result
    }
}