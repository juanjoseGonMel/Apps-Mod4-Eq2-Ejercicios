package com.Modulo4.androidbasic12.ejerciciosclase.ejercicio1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Modulo4.androidbasic12.R

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit_intent)

        val btnSent = findViewById<Button>(R.id.btnSend)
        val btnSentUrl = findViewById<Button>(R.id.btnSendUrl)

        btnSent.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_SUBJECT,"Aviso Urgente")
                putExtra(Intent.EXTRA_TEXT,"Este es un mensaje de prueba de email.")
            }
            startActivity(Intent.createChooser(emailIntent,"Enviar email usando:"))
        }

        btnSentUrl.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.com"))
            startActivity(Intent.createChooser(urlIntent,"Abrir usando:"))
        }
    }
}