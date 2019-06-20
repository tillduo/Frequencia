package com.tillduo.frequencia

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import cadastro.model.ManagerUsuario
import kotlinx.android.synthetic.main.layout_cadastro.*

class CadastroActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_cadastro)

        lblIrParaLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        btnCadastrar.setOnClickListener{
            if (verificarEmail()){
                if (verificarNull() && verificarSenha()){
                    ManagerUsuario.cadastrar(txtNomeCadastro.text.toString(), txtEmailCadastro.text.toString(), txtSenhaCadastro.text.toString())

                    val builder = android.support.v7.app.AlertDialog.Builder(this)
                    builder.setTitle("Atenção")

                    builder.setPositiveButton("Ok"){
                            dialog,wich ->
                        ManagerUsuario.acessar(txtEmailCadastro.text.toString(), txtSenhaCadastro.text.toString())

                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }

                    builder.setMessage("Cadastro realizado com sucesso")
                    val alert = builder.create()
                    alert.show()
                }
            }
        }
    }

    fun verificarNull(): Boolean{
        if (txtNomeCadastro.text.isEmpty())
            return false
        else if (txtEmailCadastro.text.isEmpty())
            return false
        else if (txtSenhaCadastro.text.isEmpty())
            return false

        return true
    }

    fun verificarSenha(): Boolean{
        if (!txtSenhaCadastro.text.toString()?.equals(txtConfirmSenhaCadastro.text.toString()))
            return false

        return true
    }

    fun verificarEmail(): Boolean{
        if (ManagerUsuario.verificarDuplicacao(txtEmailCadastro.text.toString())){
            val builder = android.support.v7.app.AlertDialog.Builder(this)
            builder.setTitle("Atenção")

            builder.setPositiveButton("Ok"){
                    dialog,wich ->
                txtEmailCadastro.setText("")
            }

            builder.setMessage("Este email já está cadastrado para outro usuário")
            val alert = builder.create()
            alert.show()
        }

        return true
    }

    override fun onBackPressed() {
        finish()
    }
}
