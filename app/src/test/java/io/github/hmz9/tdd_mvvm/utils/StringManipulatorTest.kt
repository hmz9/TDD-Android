package io.github.hmz9.tdd_mvvm.utils

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class StringManipulatorTest {

    lateinit var stringManipulator: StringManipulator

    @Before
    fun setUp(){
        stringManipulator = StringManipulator()
    }

    @Test
    fun `should return error if string is empty`() {

        val result = stringManipulator.reverseString("")
        assertTrue("String can't be empty", result.isEmpty())

    }

    @Test
    fun `should return true if string is not empty`() {

        val result = stringManipulator.reverseString("Hamza")
        assertEquals("azmaH", result)

    }
}