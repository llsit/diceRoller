package com.scode.admin.diceroller

import com.scode.admin.diceroller.Login.LoginService
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LoginServiceTest {
    private lateinit var service: LoginService

    @Before
    fun setUp() {
        service = LoginService()
    }

    @Test
    fun `should return true when username and password correct`() {
        val output = service.login("admin", "admin")
        assertEquals(true, output)
    }

    @Test
    fun `should return false when username or password incorrect`() {
        val output = service.login("bob", "5555")
        assertEquals(false, output)
    }
}