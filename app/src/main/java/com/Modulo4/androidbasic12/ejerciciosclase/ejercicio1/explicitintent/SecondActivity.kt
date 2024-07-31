package com.Modulo4.androidbasic12.ejerciciosclase.ejercicio1.explicitintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Modulo4.androidbasic12.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val labelname = findViewById<TextView>(R.id.labelname)
        val btnreturn = findViewById<Button>(R.id.btnReturn)

        intent.extras?.let {
            if (it.containsKey("EXTRA_NAME_KEY")){
                val name = it.getString("EXTRA_NAME_KEY","no sehjh")
                labelname.text=name
            }
            if (it.containsKey("EXTRA_NAME_KEY")){
                val age = it.getInt("EXTRA_AGE",0)
            }
        }

        btnreturn.setOnClickListener {
            val resultsIntent = Intent().apply {
                putExtra("EXTRA_IS_CORRECT_KEY",true)
            }

            setResult(RESULT_OK, resultsIntent)
            finish()
        }
    }
}