package com.scode.admin.diceroller.Login

import com.scode.admin.diceroller.R

class LoginPresenter(private val view: LoginView, private val service: LoginService) {
    fun onLoginClicked() {
        val username: String = view.getUsername()
        if (username.isEmpty()) {
            view.showUsernameError(R.string.username_error)
            return
        }
        val password: String = view.getPassword()
        if (password.isEmpty()) {
            view.showPasswordError(R.string.password_error)
            return
        }
        val isLoginSuccess: Boolean = service.login(username, password)
        if (isLoginSuccess) {
            view.startMainActivity()
            return
        }
        view.showLoginError(R.string.login_failed)
    }
}