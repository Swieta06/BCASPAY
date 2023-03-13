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
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra(LoginActivity.KEY_EMAIL)

        val mainAdapter = HomeMainAdapter(
            dataNews = populateData(),
            onclickNews = {
                DetilNewsActivity.navigateToActivityDetil(this, it)
            }
        )
        binding.rvNews.adapter = mainAdapter

        val mainAdapterList = HomeMainListAdapter(
            dataNewsList = populateDataLis(),
            onclickNews = {
                DetilNewsListActivity.navigateToActivityListDetil(this, it)
            }
        )
        binding.rvNewsLatest.adapter = mainAdapterList

        binding.componenAppBar.ivProfile.setOnClickListener {
//            val email=binding.inputEmail.text.toString()
//            val password=binding.inputPassword.text.toString()
            navigationScreenWithInput(BiodataActivity::class.java, "Swieta@gmail.com", "1234")
        }

        binding.componenAppBar.tvAppbar.text = "Hi! $name"
//        binding.rvNews2.adapter=mainAdapter
//        binding.rvNews3.adapter=mainAdapter
        binding.componenAppBar.ivBack.setOnClickListener {
            this.onBackPressed()
        }
    }

    private fun navigationScreenWithInput(
        screen: Class<*>,
        inputEmail: String,
        inputPassword: String
    ) {
        val intent = Intent(applicationContext, screen)
        intent.putExtra(LoginActivity.KEY_EMAIL, inputEmail)
        intent.putExtra(LoginActivity.KEY_PASSWORD, inputPassword)
        startActivity(intent)

    }

    private fun populateData(): List<NewsModel> {
        val listData = listOf(
            NewsModel(
                image = R.drawable.bcas_content_3,
                icon = R.drawable.bcas_content_3,
                title = "Move On ke KPR iB Take Over !",
                subtitle = "Daftarkan diri Anda untuk menjadi Mitra Referral BCA Syariah dan raih kesempatan mendapatkan cash reward dengan mereferensikan teman menggunnakan KPR iB Take Over BCA Syariah \n" +
                        "\n" +
                        "Ketentuan Mitra Referral\n" +
                        "\n" +
                        "Dapat berupa perorangan atau badan usaha (rekanan maupun non rekanan)\n" +
                        "Mengisi formulir pendaftaran sebagai Mitra Referral\n" +
                        "Membuka rekening tabungan BCA Syariah sebelum dana reward ditransfer\n" +
                        "Reward akan dikenakan pajak sesuai ketentuan yang berlaku\n" +
                        "Reward dibayarkan setelah KPR Take Over disetujui dan dicairkan\n" +
                        "Minimum plafond yang akan di-take over Rp 400 juta\n" +
                        "Cara Jadi Mitra Referral \n" +
                        "\n" +
                        "Mitra Referral dapat memberikan referral melalui email ke: bcas_brk@bcasyariah.co.id dengan format berikut: \n" +
                        "\n" +
                        "Subject : Nama Mitra Referral & Nomor Member yang diberikan oleh BCA Syariah setelah melakukan pendaftaran\n" +
                        "Isi Email:\n" +
                        "Nama Calon Nasabah yang direferensikan\n" +
                        "Nomor telepon Calon Nasabah\n" +
                        "Kota domisili Calon Nasabah"

            ),
            NewsModel(
                image = R.drawable.bcas_content_1,
                icon = R.drawable.bcas_content_1,
                title = "Dapatkan hadiah Flazz BCA Syariah!",
                subtitle = "Begini caranya..\n" +
                        "Aktivasi BCA Syariah Mobile dan buka rekening Tahapan iB sesuai ketentuan program, dapatkan hadiah kartu Flazz BCA Syariah dengan saldo Rp25.000,-\n" +
                        "\n" +
                        "Tambah lagi hadiahnya dengan buka rekening Tahapan Rencana iB. Kamu akan dapat tambahan saldo di kartu Flazz BCA Syariah kamu sebesar Rp50.000.- \n" +
                        "\n" +
                        "Syarat & ketentuan :\n" +
                        "\n" +
                        "Setoran awal minimal Rp100.000 pada saat pembukaan Tahapan iB.\n" +
                        "\n" +
                        "Aktivasi BCA Syariah Mobile.\n" +
                        "\n" +
                        "Setoran awal minimal Rp500.000 untuk Tahapan Rencana iB dengan jangka waktu minimal 1 tahun.\n" +
                        "\n" +
                        "Progam hanya berlaku untuk nasabah baru yang belum memiliki tabungan BCA Syariah sebelumnya.\n" +
                        "\n" +
                        "Sumber dana setoran bulanan Tahapan Rencana iB berasal dari rekening tabungan yang baru dibuat selama periode program.\n" +
                        "\n" +
                        "Program promo ini berlaku mulai 6 Februari - 30 Juni 2023."
            ),
            NewsModel(
                image = R.drawable.bcas_content_2,
                icon = R.drawable.bcas_content_2,
                title = "Daftar Haji Sekarang di BCA Syariah",
                subtitle = "Ikuti program promo Setor Biaya Ibadah Haji, Dapat Subsidi Setoran Tahapan Mabrur iB Rp100.000,-\n" +
                        "\n" +
                        "Caranya mudah!  Datang dan lakukan penyetoran biaya ibadah Haji di seluruh cabang BCA Syariah, cek di sini cara Setor Biaya Haji di BCA Syariah\n" +
                        "\n" +
                        "Ketentuan Program:\n" +
                        "\n" +
                        "Program berlaku hingga 31 Maret 2023\n" +
                        "Berlaku untuk nasabah yang melakukan setoran biaya ibadah Haji di BCA Syariah\n" +
                        "Subsidi berlaku untuk 1 rekening Tahapan Mabrur iB/Nasabah \n" +
                        "Subsidi langsung dikreditkan ke rekening Tahapan Mabrur iB nasabah\n" +
                        "Informasi lebih lanjut hubungi Halo BCA 1500888."
            ),

            )
        return listData

    }

    private fun populateDataLis(): List<ListModel> {
        val listData = listOf(
            ListModel(
                image = R.drawable.bcas_content_1,
                title = "Dapatkan hadiah Flazz BCA Syariah!",
                subtitle = "Begini caranya..\n" +
                        "Aktivasi BCA Syariah Mobile dan buka rekening Tahapan iB sesuai ketentuan program, dapatkan hadiah kartu Flazz BCA Syariah dengan saldo Rp25.000,-\n" +
                        "\n" +
                        "Tambah lagi hadiahnya dengan buka rekening Tahapan Rencana iB. Kamu akan dapat tambahan saldo di kartu Flazz BCA Syariah kamu sebesar Rp50.000.- \n" +
                        "\n" +
                        "Syarat & ketentuan :\n" +
                        "\n" +
                        "Setoran awal minimal Rp100.000 pada saat pembukaan Tahapan iB.\n" +
                        "\n" +
                        "Aktivasi BCA Syariah Mobile.\n" +
                        "\n" +
                        "Setoran awal minimal Rp500.000 untuk Tahapan Rencana iB dengan jangka waktu minimal 1 tahun.\n" +
                        "\n" +
                        "Progam hanya berlaku untuk nasabah baru yang belum memiliki tabungan BCA Syariah sebelumnya.\n" +
                        "\n" +
                        "Sumber dana setoran bulanan Tahapan Rencana iB berasal dari rekening tabungan yang baru dibuat selama periode program.\n" +
                        "\n" +
                        "Program promo ini berlaku mulai 6 Februari - 30 Juni 2023."

            ),
            ListModel(
                image = R.drawable.bcas_content_2,
                title = "Daftar Haji Sekarang di BCA Syariah",
                subtitle = "Ikuti program promo Setor Biaya Ibadah Haji, Dapat Subsidi Setoran Tahapan Mabrur iB Rp100.000,-\n" +
                        "\n" +
                        "Caranya mudah!  Datang dan lakukan penyetoran biaya ibadah Haji di seluruh cabang BCA Syariah, cek di sini cara Setor Biaya Haji di BCA Syariah\n" +
                        "\n" +
                        "Ketentuan Program:\n" +
                        "\n" +
                        "Program berlaku hingga 31 Maret 2023\n" +
                        "Berlaku untuk nasabah yang melakukan setoran biaya ibadah Haji di BCA Syariah\n" +
                        "Subsidi berlaku untuk 1 rekening Tahapan Mabrur iB/Nasabah \n" +
                        "Subsidi langsung dikreditkan ke rekening Tahapan Mabrur iB nasabah\n" +
                        "Informasi lebih lanjut hubungi Halo BCA 1500888."
            ),
            ListModel(
                image = R.drawable.bcas_content_3,
                title = "Ajak teman Move On ke KPR iB Take Over langsung dapat cuan!",
                subtitle = "Daftarkan diri Anda untuk menjadi Mitra Referral BCA Syariah dan raih kesempatan mendapatkan cash reward dengan mereferensikan teman menggunnakan KPR iB Take Over BCA Syariah \n" +
                        "\n" +
                        "Ketentuan Mitra Referral\n" +
                        "\n" +
                        "Dapat berupa perorangan atau badan usaha (rekanan maupun non rekanan)\n" +
                        "Mengisi formulir pendaftaran sebagai Mitra Referral\n" +
                        "Membuka rekening tabungan BCA Syariah sebelum dana reward ditransfer\n" +
                        "Reward akan dikenakan pajak sesuai ketentuan yang berlaku\n" +
                        "Reward dibayarkan setelah KPR Take Over disetujui dan dicairkan\n" +
                        "Minimum plafond yang akan di-take over Rp 400 juta\n" +
                        "Cara Jadi Mitra Referral \n" +
                        "\n" +
                        "Mitra Referral dapat memberikan referral melalui email ke: bcas_brk@bcasyariah.co.id dengan format berikut: \n" +
                        "\n" +
                        "Subject : Nama Mitra Referral & Nomor Member yang diberikan oleh BCA Syariah setelah melakukan pendaftaran\n" +
                        "Isi Email:\n" +
                        "Nama Calon Nasabah yang direferensikan\n" +
                        "Nomor telepon Calon Nasabah\n" +
                        "Kota domisili Calon Nasabah"
            ),
            ListModel(
                image = R.drawable.bcas_content_4,
                title = "Pengumuman Cabang Tidak Beroperasi Sementara",
                subtitle ="Assalamualaikum Warahmatullahi Wabarakatuh,\n" +
                        "Nasabah Yth,\n" +
                        "Kami informasikan bahwa pada: \n" +
                        "\n" +
                        "Senin, 23 Januari 2023\n" +
                        "BCA Syariah Tidak Beroperasi \n" +
                        " \n" +
                        "\n" +
                        "Bank akan kembali beroperasi secara normal mulai Selasa, 24 Januari 2023\n" +
                        "\n" +
                        "Demi keamanan dan kenyamanan nasabah dalam bertransaksi, kami menghimbau :\n" +
                        "\n" +
                        "Berhati-hati dalam penggunaan fasilitas e-channel BCA Syariah baik Kartu Debit, BCA Syariah Mobile maupun Klik BCA Syariah agar tetap berfungsi dengan baik.\n" +
                        "Hindari kesalahan pengisian PIN Kartu Debit, BCA Syariah Mobile, Klik BCA Syariah maupun Key BCA Syariah dan lakukan penyimpanan perangkat secara aman.\n" +
                        "Untuk informasi lebih lanjut, hubungi: Halo BCA 1500888\n" +
                        "\n" +
                        "Wassalamualaikum Warahmatullahi Wabarakatuh,\n" +
                        "\n" +
                        "Hormat kami,\n" +
                        "\n" +
                        "Manajemen BCA Syariah"
            )
        )
        return listData

    }
}