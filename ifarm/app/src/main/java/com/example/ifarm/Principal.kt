package com.example.ifarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_instrucoes_iniciais.*
import kotlinx.android.synthetic.main.activity_principal.*
import org.jetbrains.anko.db.insert


class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val textoEmail = findViewById<EditText>(R.id.email)

        val botaoConsultar = findViewById<Button>(R.id.consulta)

        botaoConsultar.setOnClickListener{
            database.use {
                    val idEmail = insert("Email",
                        "email" to textoEmail.text.toString()
                    )
                    if(idEmail != -1L) {
                        toast("Consultando...\n$idEmail: ${textoEmail.text.toString()}")
                        textoEmail.text.clear()
                    } else {
                        toast("Eroo ao inserir no banco de dados")
                    }
            }
        }

        ver_email.setOnClickListener(){
            intent = Intent(this, TelaEmail::class.java)
            startActivity(intent)
        }
    }

    private fun toast(mensagem: String) {
        Toast.makeText(applicationContext,mensagem,Toast.LENGTH_LONG).show()
    }
}