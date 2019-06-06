package com.tillduo.frequencia

import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.layout_registro_diario.*

class RegistroDiarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_registro_diario)

        txtCalendar.text = intent.getStringExtra("data")

        imVoltar.setOnClickListener{
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        startActivity( Intent(this, MainActivity::class.java))
        finish()
    }
}
