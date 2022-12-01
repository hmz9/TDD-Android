package io.github.hmz9.tdd_mvvm.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    lateinit var helper: Helper

    @Before
    fun setUp(){
        helper = Helper()
        println("Before Every Test Case")
    }

    @After
    fun tearDown(){
        println("After Every Test Case")
    }

    @Test
    fun `should provide false because not palindrome`() {
        //Act
        val result = helper.isPallindrome("hello")
        //Assert
        assertEquals(false, result)
    }

    @Test
    fun `should provide true because palindrome`() {
        //Act
        val result = helper.isPallindrome("level")
        //Assert
        assertEquals(true, result)
    }
}