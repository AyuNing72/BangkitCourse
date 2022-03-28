package com.example.github_user_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailUser2 : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user2)

        supportActionBar?.title = "Detail User"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val imgAvatar: ImageView = findViewById(R.id.img_detail_avatar)
        val tvfullnama: TextView = findViewById(R.id.nama_full)
        val tvfullnama2: TextView = findViewById(R.id.nama_full2)
        val usernama1: TextView = findViewById(R.id.Usernama)
        val username2: TextView = findViewById(R.id.Usernama2)
        val pengikut: TextView = findViewById(R.id.followers_jmlh)
        val mengikut: TextView = findViewById(R.id.following_jmlh)
        val repost: TextView = findViewById(R.id.Repository_jmlh)
        val located: TextView = findViewById(R.id.Lokasi1)
        val perusahaan: TextView = findViewById(R.id.company3)
        val uSer = intent.getParcelableExtra<Hero>(EXTRA_USER) as Hero

        val tvfoto = uSer.photo
        val tvnama = uSer.name.toString()
        val tvuser = uSer.user
        val tvPengikut = uSer.pengikut
        val tvMengikuti = uSer.mengikuti
        val tvRepository = uSer.repositori
        val tvlokasi = uSer.lokasi
        val tvPerushaan = uSer.perusahaan

        Glide.with(this).load(tvfoto).into(imgAvatar)
        tvfullnama.text= tvnama
        tvfullnama2.text=tvnama
        usernama1.text=tvuser
        username2.text=tvuser
        pengikut.text= tvPengikut.toString()
        mengikut.text=tvMengikuti.toString()
        repost.text=tvRepository.toString()
        located.text=tvlokasi
        perusahaan.text=tvPerushaan
    }

    fun back(v: View) {
        val moveIntent = Intent(this@DetailUser2, MainActivity::class.java)
        startActivity(moveIntent)
    }
}