package com.tillduo.frequencia

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Vibrator
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView
import me.dm7.barcodescanner.zxing.ZXingScannerView.ResultHandler

class CameraActivity : AppCompatActivity(), ResultHandler {

    private val REQUEST_CAMERA = 1
    private var scanner: ZXingScannerView? = null

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
            onBackPressed()
        }

        builder.setMessage(mensagem)
        val alert = builder.create()
        alert.show()
    }
}
