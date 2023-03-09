package com.example.bcaspay.view.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bcaspay.R
import com.example.bcaspay.databinding.ActivityHomeBinding
import com.example.bcaspay.model.ListModel
import com.example.bcaspay.model.NewsModel
import com.example.bcaspay.view.biodata.BiodataActivity
import com.example.bcaspay.view.detil.DetilNewsActivity
import com.example.bcaspay.view.detil.DetilNewsListActivity
import com.example.bcaspay.view.login.LoginActivity

class HomeMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name=intent.getStringExtra(LoginActivity.KEY_EMAIL)

        val mainAdapter=HomeMainAdapter(
            dataNews = populateData(),
            onclickNews = {
                DetilNewsActivity.navigateToActivityDetil(this,it)
            }
        )
        binding.rvNews.adapter=mainAdapter

        val mainAdapterList=HomeMainListAdapter(
            dataNewsList = populateDataLis(),
            onclickNews = {
               DetilNewsListActivity.navigateToActivityListDetil(this,it)
            }
        )
        binding.rvNewsLatest.adapter=mainAdapterList

        binding.componenAppBar.ivProfile.setOnClickListener {
//            val email=binding.inputEmail.text.toString()
//            val password=binding.inputPassword.text.toString()
            navigationScreenWithInput(BiodataActivity::class.java,"Swieta@gmail.com","1234")
        }

        binding.componenAppBar.tvAppbar.text="Hi! $name"
//        binding.rvNews2.adapter=mainAdapter
//        binding.rvNews3.adapter=mainAdapter
    }
    private fun navigationScreenWithInput(screen: Class<*>, inputEmail:String, inputPassword:String){
        val intent=Intent(applicationContext,screen)
        intent.putExtra(LoginActivity.KEY_EMAIL,inputEmail)
        intent.putExtra(LoginActivity.KEY_PASSWORD,inputPassword)
        startActivity(intent)

    }
    private fun populateData():List<NewsModel>{
        val listData= listOf(
            NewsModel(
                image = R.drawable.bcas,
                icon = R.drawable.bcas,
                title = "Tarik tunai Cardless di ATM BCA",
                subtitle = "Bagi Anda yang ingin belanja melalui Shopee dan Tokopedia maka bis mendapatkan promo dan diskon."

            ),
            NewsModel(
                image = R.drawable.bca2,
                icon = R.drawable.bca2,
                title = "Daftar Promo HUT BCA ke-66: Sushi Tei-Chatime Rp6 Ribu",
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
    private fun populateDataLis():List<ListModel>{
        val listData= listOf(
            ListModel(
                image = R.drawable.bca,
                title = "Pakai BCA, Ada Diskon 66 Persen di Shopee dan Tokopedia",
                subtitle = "Bagi Anda yang ingin belanja melalui Shopee dan Tokopedia maka bis mendapatkan promo dan diskon."

            ),
            ListModel(
                image = R.drawable.bca2,
                title = "Daftar Promo HUT BCA ke-66: Sushi Tei-Chatime Rp6 Ribu",
                subtitle = "Berikut daftar promo HUT BCA ke-66 yang diberikan untuk pembelian makanan, minuman, hingga transaksi e-commerce."
            ),
            ListModel(
                image = R.drawable.plane,
                title = "Gebyar HUT ke-66 BCA, Begini Cara Dapat Tiket Pesawat Murah",
                subtitle = "Sriwijaya Air memberi diskon besar-besaran pada momen HUT ke-66 BCA. Segini harga tiketnya."
            ),

            )
        return listData

    }
}