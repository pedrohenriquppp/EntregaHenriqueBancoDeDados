package com.example.ifarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_instrucoes_iniciais.*

class InstrucoesIniciais : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instrucoes_iniciais)

        button2.setOnClickListener(){
            intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }
    }
}