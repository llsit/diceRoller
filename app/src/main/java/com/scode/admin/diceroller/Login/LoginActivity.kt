package com.scode.admin.diceroller.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.scode.admin.diceroller.MainActivity
import com.scode.admin.diceroller.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    private lateinit var presenter: LoginPresenter

    override fun getUsername(): String {
        return editTextUsername.text.toString()
    }

    override fun getPassword(): String {
        return editTextPassword.text.toString()
    }

    override fun showUsernameError(resId: Int) {
        editTextUsername.error = getString(resId)
    }

    override fun showPasswordError(resId: Int) {
        editTextPassword.error = getString(resId)
    }

    override fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun showLoginError(resId: Int) {
        Toast.makeText(this, getString(resId), LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        this.presenter = LoginPresenter(this, LoginService())
        this.handleTextChanged()
    }

    private fun handleTextChanged() {
        editTextUsername.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })

        editTextPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }

    fun onLoginClicked() {
        presenter.onLoginClicked()
    }
}
