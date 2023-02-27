package com.example.bcaspay.view.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bcaspay.R
import com.example.bcaspay.databinding.ActivityHomeBinding
import com.example.bcaspay.model.NewsModel

class HomeMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mainAdapter=HomeMainAdapter(populateData())
        binding.rvNews.adapter=mainAdapter
    }
    private fun populateData():List<NewsModel>{
        val listData= listOf(
            NewsModel(
                image = R.drawable.bca,
                icon = R.drawable.bca,
                title = "Pakai BCA, Ada Diskon 66 Persen di Shopee dan Tokopedia",
                subtitle = "Bagi Anda yang ingin belanja melalui Shopee dan Tokopedia maka bis mendapatkan promo dan diskon."

            ),
            NewsModel(
                image = R.drawable.bca2,
                icon = R.drawable.bca2,
                title = "Daftar Promo HUT BCA ke-66: Sushi Tei-Chatime Rp6 Ribu, Starbucks-Subway Diskon 66%",
                subtitle = "Berikut daftar promo HUT BCA ke-66 yang diberikan untuk pembelian makanan, minuman, hingga transaksi e-commerce."
            ),
            NewsModel(
                image = R.drawable.plane,
                icon = R.drawable.plane,
                title = "Gebyar HUT ke-66 BCA, Begini Cara Dapat Tiket Pesawat Murah",
                subtitle = "Sriwijaya Air memberi diskon besar-besaran pada momen HUT ke-66 BCA. Segini harga tiketnya."
            ),

            )
        return listData

    }
}