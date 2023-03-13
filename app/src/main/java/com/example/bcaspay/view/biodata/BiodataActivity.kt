package com.example.bcaspay.view.biodata

import android.accounts.AccountManager.KEY_PASSWORD
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcaspay.R
import com.example.bcaspay.databinding.ActivityBiodataBinding
import com.example.bcaspay.base.BaseDialog
import com.example.bcaspay.view.login.LoginActivity
import com.example.bcaspay.view.login.LoginActivity.Companion.KEY_EMAIL
import com.example.bcaspay.view.register.RegisterActivity

class BiodataActivity:AppCompatActivity() {
    private lateinit var binding:ActivityBiodataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBiodataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name=intent.getStringExtra(KEY_EMAIL)
        val password=intent.getStringExtra(KEY_PASSWORD)
        binding.txtProfileName.text=name
        binding.txtPassword.text=password
        binding.componenAppBar.tvAppbar.text="Profile"
        binding.componenAppBar.ivProfile.visibility= View.GONE
        binding.componenAppBar.ivBack.setOnClickListener{
            this.onBackPressed()
        }
        logout()
    }
    private fun logout(){
        binding.constraintButton.setOnClickListener {
            val dialog=BaseDialog(this,
                "Warning !",
                "Are you sure want to logout?",
                onClicked = {
                    val intent= Intent(applicationContext, LoginActivity::class.java)
                    startActivity(intent)
                Toast.makeText(applicationContext,"Success Logout ",Toast.LENGTH_LONG).show()
                    //finish()
                }, withImage = false,
                image = R.drawable.ic_launcher_background
            )
            dialog.setCancelable(false)
            dialog.show()
        }


    }

}