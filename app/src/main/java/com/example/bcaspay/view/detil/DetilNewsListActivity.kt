package com.example.bcaspay.view.detil

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bcaspay.databinding.ActivityDetilNewsBinding
import com.example.bcaspay.model.ListModel
class DetilNewsListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetilNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetilNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setDatatViewListDetil()
    }
    private fun setDatatViewListDetil(){
        val data=intent.getParcelableExtra<ListModel>(DATA_NEWS_LIST)
        if (data != null) {
            binding.ivDetilNews.setImageResource( data.image?:0)
        }
        binding.tvDetilTitleNews.text=data?.title
        binding.tvDetilDescriptionNews.text=data?.subtitle

    }
    companion object {
        const val DATA_NEWS_LIST = "dataNewsList"
        fun navigateToActivityListDetil(
            activity: Activity, dataNewsList: ListModel) {
            val inten = Intent(activity, DetilNewsActivity::class.java)
            inten.putExtra(DATA_NEWS_LIST, dataNewsList)
            activity.startActivity(inten)
        }
    }
}