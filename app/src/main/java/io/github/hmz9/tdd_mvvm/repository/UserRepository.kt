package io.github.hmz9.tdd_mvvm.repository

import io.github.hmz9.tdd_mvvm.models.LOGIN_STATUS
import io.github.hmz9.tdd_mvvm.models.User

class UserRepository {

    val users = listOf<User>(
        User(1, "Hamza", "hamza@gmail.com", "234sdkjhrA"),
        User(2, "Ali", "ali@gmail.com", "4SFGfrgET$"),
        User(3, "Adnan", "adnan@gmail.com", "GBfhe23F%"),
    )

    fun loginUser(email: String, password: String): LOGIN_STATUS {

        //Fetching user from DB
        val users = users.filter { user -> user.email == email }
        return if (users.size == 1) {
            if(users[0].password == password){
                LOGIN_STATUS.SUCCESS
            } else {
                LOGIN_STATUS.INVALID_PASSWORD
            }
        }
        else{
            LOGIN_STATUS.INVALID_USER
        }
    }
}