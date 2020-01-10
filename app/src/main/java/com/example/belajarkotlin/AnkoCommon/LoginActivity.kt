package com.example.belajarkotlin.AnkoCommon

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.belajarkotlin.R
import kotlinx.android.synthetic.main.login_layout.*
import org.jetbrains.anko.*

class LoginActivity : AppCompatActivity(), AnkoLogger{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    setContentView(R.layout.login_layout)

        btn_login.setOnClickListener {
            val username = edt_user2.text.toString().trim()
            val password = edt_pass2.text.toString().trim()
            handleOnLogin(username = username, password = password)
        }

        btn_register.setOnClickListener {
            startActivity(intentFor<RegisterActivity>())
            Toast.LENGTH_SHORT
        }
    }

    private fun handleOnLogin(username: String, password: String) {
        debug { "username: $username and password: $password" }

        if (username == "anko" && password == "kotlin"){
            toast("Hi $username, You're logged in")
            //longToast bisa juga
        }else{
            alert ( title = getString(R.string.title_login_failed),
            message = getString(R.string.message_login_failed)){
                positiveButton(buttonText = "OK"){

                }
            }.show()
        }
    }

}