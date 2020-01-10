package com.example.belajarkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class Login : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        button = findViewById(R.id.btn_login)
        button.setOnClickListener {

            val username = edt_user.text.toString()
            val password = edt_pass.text.toString()

            if(username.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Masukkan username dan password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else if (username == "admin" && password == "admin"){
                startActivity(Intent(this, Home::class.java))
            }else{
                Toast.makeText(this, "Username atau password anda salah", Toast.LENGTH_SHORT).show()
            }

        }

    }

}
