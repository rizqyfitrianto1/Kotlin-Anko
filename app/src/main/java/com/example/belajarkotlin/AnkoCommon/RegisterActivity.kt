package com.example.belajarkotlin.AnkoCommon

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.belajarkotlin.R
import kotlinx.android.synthetic.main.register_layout.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.alert
import org.jetbrains.anko.debug
import org.jetbrains.anko.toast

class RegisterActivity : AppCompatActivity(), AnkoLogger{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_layout)

        btn_register.setOnClickListener {
            val fullName = edt_fullname.text.toString().trim()
            val username = edt_username.text.toString().trim()
            val password = edt_password.text.toString().trim()
            handleOnRegister(fullName = fullName, username = username, password = password)
        }
    }

    private fun handleOnRegister(fullName: String, username: String, password: String) {
        debug { "fullName: $fullName & username: $username & password: $password"}
        when{
            fullName.isEmpty() -> toast("FullName is required.")
            username.isEmpty() -> toast("Username is required.")
            password.isEmpty() -> toast("Password is required.")
            else -> alert  (title = "Register", message = "Your account has been created!") {
                positiveButton("OK"){
                    onBackPressed()
                }
            }.show()

        }
    }

}