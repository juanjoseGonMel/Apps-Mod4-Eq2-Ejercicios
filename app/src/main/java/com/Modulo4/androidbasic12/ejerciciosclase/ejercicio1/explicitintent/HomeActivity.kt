package com.Modulo4.androidbasic12.ejerciciosclase.ejercicio1.explicitintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Modulo4.androidbasic12.R

class HomeActivity : AppCompatActivity() {

    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){
            val isCorrect = it.data?.getBooleanExtra("EXTRA_IS_CORRECT_KEY",false)
            if (isCorrect == true){
                onBackPressedDispatcher.onBackPressed()
            }else{
                Toast.makeText( this,"Result Extra $isCorrect", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText( this,"CANCELED", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val btnSendActivity = findViewById<Button>(R.id.btnSendActivity)
        btnSendActivity.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME_KEY","Juan Jose")
                putExtra("EXTRA_AGE",26)
            }
            register.launch(intent)
            //startActivity(intent)
        }
    }
}