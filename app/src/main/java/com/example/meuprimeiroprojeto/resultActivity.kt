package com.example.meuprimeiroprojeto

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class resultActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvclassificacao = findViewById<TextView>(R.id.textview_Classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        val Classificação = if (result < 18.5f) {
             "ABAIXO DO PESO"
        }else if (result in 18.5f..24.9f) {
            "Normal"
        }else if (result in 25f..29.9f) {
            "SOBREPESO"
        }else if (result in 30f..39.9f) {
            "OBESIDADE"
        }else{
            "OBESIDADE GRAVE"
        }
        tvclassificacao.text = getString(R.string.message_classificacao, Classificação)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}