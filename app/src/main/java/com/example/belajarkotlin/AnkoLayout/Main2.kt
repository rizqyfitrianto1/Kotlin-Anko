package com.example.belajarkotlin.AnkoLayout

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.belajarkotlin.AnkoCommon.RegisterActivity
import com.example.belajarkotlin.R
import org.jetbrains.anko.*
import org.w3c.dom.Text

class Main2 : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SignInView().setContentView(this)

        var bton : Button = findViewById(R.id.bton)
        var uname : EditText = findViewById(R.id.usernameET)
        var passwd : EditText = findViewById(R.id.passwordET)
        var regis : TextView = findViewById(R.id.tv_register)

        bton.setOnClickListener {
            val username = uname.text.toString().trim()
            val password = passwd.text.toString().trim()
            handleLogin(username, password)
        }

        regis.setOnClickListener {
            startActivity(intentFor<RegisterActivity>())
        }
    }

    class SignInView:AnkoComponent<Main2>{
        override fun createView(ui: AnkoContext<Main2>)= with(ui){
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    padding = 30
                    verticalGravity = Gravity.CENTER
                }
                verticalLayout {
                    lparams(width = matchParent, height = wrapContent) {
                        backgroundColor = Color.WHITE
                        margin = 15
                        padding = 20
                    }
                    textView {
                        id = R.id.samppleTV
                        hintResource = R.string.login
                        textSize = 25F
                        textColor = Color.CYAN
                        textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    }.lparams(
                        width = matchParent,
                        height = wrapContent
                    ) {
                        margin = 15
                    }
                    editText {
                        id = R.id.usernameET
                        hintResource = R.string.signin_uname
                        textSize = 20f
                        inputType = InputType.TYPE_CLASS_TEXT
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }
                    editText {
                        id = R.id.passwordET
                        hintResource = R.string.signin_passwd
                        textSize = 20f
                        inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }

                    button(R.string.login) {
                        textResource = R.string.login
                        id = R.id.bton
                    }.lparams(width = wrapContent, height = wrapContent) {
                        margin = 15
                        gravity = Gravity.CENTER
                    }
                    textView {
                        id = R.id.tv_register
                        hint = "Create Account?"
                        textSize = 15F
                        textColor = R.color.warnaBiruMuda
                        textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }
                }
            }
        }


    }

    private fun handleLogin(username: String, password: String) {
        info { "data username : $username , data password : $password" }
        if (username == "test" && password == "test123"){
            toast("Welcome Aboard $username")
        }else{
            alert ( title = "Login Gagal", message = "Password atau Username salah" ){
                positiveButton(buttonText = "OK"){

                }
                isCancelable = false
            }.show()
        }
    }

}


