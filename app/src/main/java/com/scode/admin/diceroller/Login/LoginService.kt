package com.scode.admin.diceroller.Login

class LoginService {
    fun login(username: String, password: String): Boolean {
        return username == "admin" && password == "admin"
    }
}