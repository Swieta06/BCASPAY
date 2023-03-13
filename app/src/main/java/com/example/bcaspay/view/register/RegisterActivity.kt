package com.example.bcaspay.view.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bcaspay.databinding.ActivityRegisterBinding
import com.example.bcaspay.view.login.LoginActivity

class RegisterActivity:AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtLoginAccount.setOnClickListener {
            val intent= Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}