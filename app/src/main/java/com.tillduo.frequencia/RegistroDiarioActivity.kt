package com.tillduo.frequencia

import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.layout_registro_diario.*
import reciclerview.Registro
import reciclerview.RegistroListAdapter
import android.os.Build
import android.support.annotation.RequiresApi
import me.dm7.barcodescanner.zxing.ZXingScannerView
import java.time.DayOfWeek
import java.time.LocalDateTime


class RegistroDiarioActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    val localDate = LocalDateTime.now()
    @RequiresApi(Build.VERSION_CODES.O)
    var dataCadInicial = ""+ (converterSemana(localDate.dayOfWeek))+ "\n" +(localDate.dayOfMonth)+"/"+(localDate.monthValue)+"/"+(localDate.year) + "\n" +(localDate.hour)+":"+(localDate.minute)+":"+(localDate.second)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_registro_diario)

        var dataHoje = intent.getStringExtra("data")

        val recyclerView = listaRegistros
        criaRegistroInicial(recyclerView)
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager

        txtDia.text = dataHoje

        var flag = 0

        val e = intent.getExtras()
        if (e != null) {
            val mensagem = e!!.getString("mensagem")
            flag = e!!.getInt("flag")

            if(flag == 1){
                val recyclerView = listaRegistros
                criaRegistros(dataHoje, "Entrada na Aula", recyclerView)
                criaRegistros(dataHoje, mensagem, recyclerView)
                val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
                recyclerView.layoutManager = layoutManager
            }
        }

        imVoltar.setOnClickListener{
            onBackPressed()
        }

        imMensal.setOnClickListener{
            startActivity(Intent(this, RegistroMensalActivity::class.java))
            finish()
        }

        fab.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            intent.putExtra("data", dataHoje)
            startActivity(intent)
            finish()
        }

    }

    override fun onBackPressed() {
        startActivity( Intent(this, MainActivity::class.java))
        finish()
    }

    private fun criaRegistroInicial(recyclerView: RecyclerView){
        recyclerView.adapter = RegistroListAdapter(listOf(Registro(dataCadInicial, "Entrada na Aula")), this)
    }

    private fun criaRegistros(titulo: String, descricao: String, recyclerView: RecyclerView){
        recyclerView.adapter = RegistroListAdapter(listOf(Registro(dataCadInicial, "Entrada na Aula"), Registro(titulo, descricao)), this)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun converterSemana(week: DayOfWeek): String{
        var dayOfWeek: String = ""

        when(week){
            DayOfWeek.SUNDAY ->{dayOfWeek = "Domingo"}
            DayOfWeek.MONDAY ->{dayOfWeek = "Segunda-feira"}
            DayOfWeek.TUESDAY ->{dayOfWeek = "Terça-feira"}
            DayOfWeek.WEDNESDAY ->{dayOfWeek = "Quarta-feira"}
            DayOfWeek.THURSDAY ->{dayOfWeek = "Quinta-feira"}
            DayOfWeek.FRIDAY ->{dayOfWeek = "Sexta-feira"}
            DayOfWeek.SATURDAY ->{dayOfWeek = "Sábado"}
        }
        return dayOfWeek
    }
}