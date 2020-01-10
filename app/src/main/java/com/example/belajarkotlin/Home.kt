package com.example.belajarkotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class Home : AppCompatActivity() {

    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lay_home)

        btn = findViewById(R.id.btn_back)
        btn.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }

}