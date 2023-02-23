package com.example.bcaspay.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bcaspay.databinding.ActivityLoginBinding

class LoginActivity:AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtCreateAccount.setOnClickListener {
            val intent=Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }

    }

}