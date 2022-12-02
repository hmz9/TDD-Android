package io.github.hmz9.tdd_mvvm.service

import io.github.hmz9.tdd_mvvm.models.LOGIN_STATUS
import io.github.hmz9.tdd_mvvm.repository.UserRepository
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.reset

class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.loginUser(anyString(), anyString())).thenReturn(LOGIN_STATUS.INVALID_PASSWORD)
    }

    @Test
    fun testUserService() {
        val userService = UserService(userRepository)
        val result = userService.loginUser("hamza@gmail.com", password = "dljfsdlfj")
        assertEquals("Password is invalid", result)
    }

    @After
    fun tearDown() {
    }
}