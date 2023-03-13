package com.example.bcaspay.view.detil

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.bcaspay.databinding.ActivityDetilNewsBinding
import com.example.bcaspay.model.NewsModel

class DetilNewsActivity:AppCompatActivity() {
    private lateinit var binding: ActivityDetilNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetilNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setDatatViewDetil()
        binding.componenAppBar.ivBack.setOnClickListener{
            this.onBackPressed()
        }

    }
    private fun setDatatViewDetil(){
        val data=intent.getParcelableExtra<NewsModel>(DATA_NEWS)
        if (data != null) {
            binding.ivDetilNews.setImageResource( data.image?:0)
        }
        binding.tvDetilTitleNews.text=data?.title
        binding.tvDetilDescriptionNews.text=data?.subtitle
        binding.componenAppBar.tvAppbar.text=data?.title
        binding.componenAppBar.ivProfile.visibility= View.GONE

    }

    companion object{
        /**
         * scooping function
         * **/
        const val DATA_NEWS="dataNews"
        fun navigateToActivityDetil(
            activity: Activity, dataNews:NewsModel){
            val inten= Intent(activity,DetilNewsActivity::class.java)
            inten.putExtra(DATA_NEWS,dataNews)
            activity.startActivity(inten)
        }
    }
}