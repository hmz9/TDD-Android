package io.github.hmz9.tdd_mvvm.utils

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class PasswordHelperTest {

    lateinit var passwordHelper: PasswordHelper

    @Before
    fun setUp() { passwordHelper = PasswordHelper() }

    @Test
    fun `validate password correct input expected true`() {
        //Action
        val result = passwordHelper.isPasswordValid("123456")
        //Assert
        assertEquals(true, result)
    }

    @Test
    fun `validate password empty input expected false`() {
        //Action
        val result = passwordHelper.isPasswordValid("")
        //Assert
        assertEquals(false, result)
    }

    @Test
    fun `validate password input length less than 6 expected false`() {
        //Action
        val result = passwordHelper.isPasswordValid("12345")
        //Assert
        assertEquals(false, result)
    }

    @Test
    fun `validate password input length greater than 15 expected false`() {
        //Action
        val result = passwordHelper.isPasswordValid("1234567891234567")
        //Assert
        assertEquals(false, result)
    }
}