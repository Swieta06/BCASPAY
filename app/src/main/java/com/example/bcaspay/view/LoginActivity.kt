package com.example.bcaspay.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcaspay.databinding.ActivityLoginBinding

class LoginActivity:AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val emailUser="swieta@gmail.com"
        val passwordUser="1234"
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtCreateAccount.setOnClickListener {
            val intent=Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnSubmit.setOnClickListener {

            val email=binding.inputEmail.text.toString()
            val password=binding.inputPassword.text.toString()
            if (email==emailUser){
                if(password==passwordUser){
                    navigationScreenWithInput(BiodataActivity::class.java,email,password)
                    Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext, "Login Failed", Toast.LENGTH_SHORT).show()
                }


            }


        }

    }


    private fun navigationScreenWithInput(screen: Class<*>, inputEmail:String, inputPassword:String){
        val intent=Intent(applicationContext,screen)
        intent.putExtra(KEY_EMAIL,inputEmail)
        intent.putExtra(KEY_PASSWORD,inputPassword)
        startActivity(intent)

    }

    companion object{
        const val KEY_PASSWORD="password"
        const val KEY_EMAIL="email"
    }

}