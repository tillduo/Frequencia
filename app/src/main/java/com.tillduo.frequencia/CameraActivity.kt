package com.tillduo.frequencia

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Vibrator
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import me.dm7.barcodescanner.zxing.ZXingScannerView.ResultHandler
import java.time.DayOfWeek
import java.time.LocalDateTime


class CameraActivity : AppCompatActivity(), ResultHandler {

    @RequiresApi(Build.VERSION_CODES.O)
    val localDate = LocalDateTime.now()
    private val REQUEST_CAMERA = 1
    private var scanner: ZXingScannerView? = null
    @RequiresApi(Build.VERSION_CODES.O)
    var dataHoje = ""+ (converterSemana(localDate.dayOfWeek))+ "\n" +(localDate.dayOfMonth)+"/"+(localDate.monthValue)+"/"+(localDate.year) + "\n" +(localDate.hour)+":"+(localDate.minute)+":"+(localDate.second)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        scanner = ZXingScannerView(this)

        if(!checkPermission())
            requestPermission()

        setContentView(scanner)
    }

    private fun checkPermission() : Boolean {
        return ContextCompat.checkSelfPermission(this@CameraActivity,
            android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission(){
        ActivityCompat.requestPermissions(this,
            arrayOf(android.Manifest.permission.CAMERA), REQUEST_CAMERA)
    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun finaliza(mensagem: String){
        val intent = Intent(this, RegistroDiarioActivity::class.java)
        intent.putExtra("mensagem", mensagem)
        intent.putExtra("flag", 1)
        intent.putExtra("data", dataHoje)
        startActivity(intent)
        finish()
    }

    override fun onResume() {
        super.onResume()

        if(checkPermission())
            if(scanner == null){
                scanner = findViewById(R.id.scanner)
                setContentView(scanner)
            }
        scanner?.setResultHandler (this)
        scanner?.startCamera()
    }

    override fun onDestroy() {
        super.onDestroy()
        scanner?.stopCamera()
    }

    override fun handleResult(result: Result?) {
        val mensagem = result?.text
        val vibrator = applicationContext.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(1000)

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Resultado")

        builder.setPositiveButton("Ok"){
                dialog,wich ->
            finaliza(mensagem.toString())
        }

        builder.setMessage(mensagem)
        val alert = builder.create()
        alert.show()
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
