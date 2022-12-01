package io.github.hmz9.tdd_mvvm.utils

import io.github.hmz9.tdd_mvvm.utils.Helper
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizedTest(val input: String, val expectedValue: Boolean) {

    lateinit var helper: Helper

    @Before
    fun setup(){
        helper = Helper()
    }

    @Test
    fun `check if palindrome` () {
        val result = helper.isPallindrome(input)
        assertEquals(expectedValue, result)
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is palindrome - {1}")
        fun testData(): List<Array<Any>>{
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true),
            )
        }

    }
}