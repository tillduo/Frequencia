package com.tillduo.frequencia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import cadastro.model.ManagerUsuario
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.nav_header_main.*
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Estava dando erro ao tentar executar
//        val db = Room.databaseBuilder(
//            applicationContext,
//            BancoDados::class.java, "banco_dados_frequencia"
//        ).build()

        cvCalendario.setOnDateChangeListener(){ view, year, month, dayOfMonth ->

            val calendar: Calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            val dayOfWeek: Int = calendar.get(Calendar.DAY_OF_WEEK)

            val intent = Intent(this, RegistroDiarioActivity::class.java)
            val data: String = ""+ (converterSemana(dayOfWeek))+ "\n" +(dayOfMonth)+"/"+(month+1)+"/"+(year)
            intent.putExtra("data", data)

            startActivity(intent)
        }

        fab.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
            finish()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    private fun converterSemana(week: Int): String{
        var dayOfWeek: String = ""

        when(week){
            1 ->{dayOfWeek = "Domingo"}
            2 ->{dayOfWeek = "Segunda-feira"}
            3 ->{dayOfWeek = "Terça-feira"}
            4 ->{dayOfWeek = "Quarta-feira"}
            5 ->{dayOfWeek = "Quinta-feira"}
            6 ->{dayOfWeek = "Sexta-feira"}
            7 ->{dayOfWeek = "Sábado"}
        }
        return dayOfWeek
    }

    override fun onBackPressed() {
       val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmação")
        builder.setMessage("Tem certeza que deseja sair?")
        builder.setPositiveButton("Cancelar") { dialog, wich ->
            onResume()
        }
        builder.setNeutralButton("Sim"){dialog, which ->
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        builder.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.acao_notificacoes -> {
                startActivity(Intent(this, NotificacaoActivity::class.java))
                return true
            }
            else -> return false
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        when (item.itemId) {
            R.id.grupos -> {
                startActivity(Intent(this, GruposActivity::class.java))
                finish()
            }
            R.id.registro_mensal -> {
                startActivity(Intent(this, RegistroMensalActivity::class.java))
                finish()
            }
            R.id.contatos -> {
                startActivity(Intent(this, ContatosActivity::class.java))
                finish()
            }
            R.id.configuracao -> {
                startActivity(Intent(this, ConfiguracaoActivity::class.java))
                finish()
            }
            R.id.duvidas -> {
                startActivity(Intent(this, DuvidasActivity::class.java))
                finish()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
