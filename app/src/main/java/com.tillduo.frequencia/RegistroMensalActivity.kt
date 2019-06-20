package com.tillduo.frequencia

import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.layout_registro_diario.*
import kotlinx.android.synthetic.main.layout_registro_mensal.*
import kotlinx.android.synthetic.main.layout_registro_mensal.fab
import kotlinx.android.synthetic.main.layout_registro_mensal.imVoltar

class RegistroMensalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_registro_mensal)

        imVoltar.setOnClickListener{
            onBackPressed()
        }

        fab.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
            finish()
        }
    }

    override fun onBackPressed() {
        startActivity( Intent(this, MainActivity::class.java))
        finish()
    }
}
