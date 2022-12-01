package io.github.hmz9.tdd_mvvm.utils

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class PasswordHelperParameterizedTest(private val input: String, private val expectedValue: Boolean) {

    @Test
    fun validatePassword(){

        //Arrange
        val passwordHelper = PasswordHelper()
        //Action
        val result = passwordHelper.isPasswordValid(input)
        //Assert
        assertEquals(expectedValue, result)
    }

    companion object{

        //Provides test data to test function
        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} password returns {1}")
        fun passwordData(): List<Array<Any>> {
            return listOf(
                arrayOf("123456", true),
                arrayOf("", false),
                arrayOf("123", false),
                arrayOf("1234567891234567", false),
            )
        }
    }
}