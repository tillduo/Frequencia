package com.tillduo.frequencia

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.layout_login.*

class LoginActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_login)

        lblIrParaCadastro.setOnClickListener{
            startActivity(Intent(this, CadastroActivity::class.java))
            finish()
        }

        btnLogar.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this, CadastroActivity::class.java))
        finish()
    }
}