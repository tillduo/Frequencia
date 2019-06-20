package com.tillduo.frequencia

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import cadastro.model.ManagerUsuario
import kotlinx.android.synthetic.main.layout_login.*

class LoginActivity : Activity() {

    companion object {
        var tentativas: Int = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_login)

        lblIrParaCadastro.setOnClickListener{
            startActivity(Intent(this, CadastroActivity::class.java))
            finish()
        }

        btnLogar.setOnClickListener{
            if(verificarNull()) {
                if (LoginActivity.tentativas > 0) {
                    if (ManagerUsuario.acessar(txtEmailLogin.text.toString(), txtSenhaLogin.text.toString())) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        this.notificacaoIncorreto()
                    }
                } else {
                    this.notificacaoEsgotado()
                }
            }
            else{
                this.notificacaoNull()
            }
        }
    }

    fun verificarNull(): Boolean{
        if (txtEmailLogin.text.isEmpty())
            return false
        else if (txtSenhaLogin.text.isEmpty())
            return false

        return true
    }

    override fun onBackPressed() {
        startActivity(Intent(this, CadastroActivity::class.java))
        finish()
    }

    fun notificacaoIncorreto(){
        val builder = android.support.v7.app.AlertDialog.Builder(this)
        builder.setTitle("Atenção")

        builder.setPositiveButton("Ok") { dialog, wich ->
            LoginActivity.tentativas -= 1
        }

        builder.setMessage("Email ou senha incorretos\nVocê ainda tem " + tentativas + " chances.")
        val alert = builder.create()
        alert.show()
    }

    fun notificacaoEsgotado(){
        val builder = android.support.v7.app.AlertDialog.Builder(this)
        builder.setTitle("Atenção")

        builder.setPositiveButton("Cancelar") { dialog, wich -> }

        builder.setNegativeButton("Ok") { dialog, wich ->
            // Refirecionar para redefinicao de senha
        }

        builder.setMessage("Número de tentativas esgotadas, você será direcionado para redefinição de senha.")
        val alert = builder.create()
        alert.show()
    }

    fun notificacaoNull(){
        val builder = android.support.v7.app.AlertDialog.Builder(this)
        builder.setTitle("Observação")

        builder.setPositiveButton("Ok") { dialog, wich -> }

        builder.setMessage("Email e senha devem ser informados.")
        val alert = builder.create()
        alert.show()
    }
}