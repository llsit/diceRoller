package com.scode.admin.diceroller

import com.scode.admin.diceroller.Login.LoginPresenter
import com.scode.admin.diceroller.Login.LoginService
import com.scode.admin.diceroller.Login.LoginView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class LoginActivityTest {
    @Mock
    private lateinit var view: LoginView
    @Mock
    private lateinit var service: LoginService
    private lateinit var presenter: LoginPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = LoginPresenter(view, service)
    }


    @Test
    fun `Should show error when username is empty`() {
        `when`(view.getUsername()).thenReturn("")
        presenter.onLoginClicked()

        verify(view).showUsernameError(R.string.username_error)
    }

    @Test
    fun `Should show error when password is empty`() {
        `when`(view.getUsername()).thenReturn("bob")
        `when`(view.getPassword()).thenReturn("")
        presenter.onLoginClicked()

        verify(view).showPasswordError(R.string.password_error)
    }

    @Test
    fun `Should start MainActivity when username and password correct`() {
        `when`(view.getUsername()).thenReturn("bob")
        `when`(view.getPassword()).thenReturn("bob1234")
        `when`(service.login("bob", "bob1234")).thenReturn(true)
        presenter.onLoginClicked()

        verify(view).startMainActivity()
    }

    @Test
    fun `Should show error when username or password incorrect`() {
        `when`(view.getUsername()).thenReturn("bob")
        `when`(view.getPassword()).thenReturn("bob1234")
        `when`(service.login("bob", "bob1234")).thenReturn(false)
        presenter.onLoginClicked()

        verify(view).showLoginError(R.string.login_failed)
    }
}