package com.example.bcaspay.view.biodata

import android.accounts.AccountManager.KEY_PASSWORD
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bcaspay.databinding.ActivityBiodataBinding
import com.example.bcaspay.view.login.LoginActivity
import com.example.bcaspay.view.login.LoginActivity.Companion.KEY_EMAIL

class BiodataActivity:AppCompatActivity() {
    private lateinit var bingding:ActivityBiodataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bingding= ActivityBiodataBinding.inflate(layoutInflater)
        setContentView(bingding.root)
        val name=intent.getStringExtra(KEY_EMAIL)
        val password=intent.getStringExtra(KEY_PASSWORD)
        bingding.txtProfileName.text=name
        bingding.txtPassword.text=password
    }

}