package com.example.bcaspay.splashScreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bcaspay.databinding.ActivityMainBinding
import com.example.bcaspay.view.login.LoginActivity

class SplashScreenActivity:AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSubmit.setOnClickListener {
            val intent= Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}