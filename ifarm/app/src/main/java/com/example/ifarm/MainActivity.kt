package com.example.ifarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val maxSplashTime: Long = 2000

        Handler().postDelayed({
            startActivity(Intent(this, InstrucoesIniciais::class.java))
            finish()
        },maxSplashTime)
    }
}