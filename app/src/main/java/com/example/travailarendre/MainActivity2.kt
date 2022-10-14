package com.example.travailarendre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
        lateinit var txt : TextView
        lateinit var btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val nom = intent.getStringExtra("nom")
        val date = intent.getStringExtra("date")
        val email = intent.getStringExtra("email")
        val classe = intent.getStringExtra("classe")

        txt = findViewById(R.id.info)
        txt.setText("L'etudiant "+nom+" Date de naissance "+date+" Email "+email+ " Classe "+classe)
        btn = findViewById(R.id.save)
        btn.setOnClickListener{
            val shareIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, nom)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, null))
        }


    }
}