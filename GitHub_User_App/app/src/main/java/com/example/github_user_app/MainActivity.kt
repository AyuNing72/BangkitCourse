package com.example.github_user_app

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var git2 : RecyclerView
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        git2=findViewById(R.id.Heroes1)
        git2.setHasFixedSize(true)

        list.addAll(listHeroes)
        showRecyclerList()
    }

    private val listHeroes: ArrayList<Hero>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataUsernme = resources.getStringArray(R.array.data_username)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val dataCompany= resources.getStringArray(R.array.data_company)
            val datalokasi= resources.getStringArray(R.array.data_location)
            val datafollower= resources.getIntArray(R.array.data_followers)
            val datafollowing= resources.getIntArray(R.array.data_following)
            val datarepository= resources.getIntArray(R.array.data_repository)

            val listHero = ArrayList<Hero>()
            for (i in dataName.indices) {
                val hero = Hero(
                    dataName[i],
                    dataUsernme[i],
                    dataPhoto.getResourceId(i, -1),
                    dataCompany[i],
                    datalokasi[i],
                    datafollower[i],
                    datafollowing[i],
                    datarepository[i])

                listHero.add(hero)
            }
            return listHero
        }

    private fun showSelectedUser(user: Hero) {
        val person = Intent(this@MainActivity, DetailUser2::class.java)
        person.putExtra(DetailUser2.EXTRA_USER, user)
        startActivity(person)
    }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            git2.layoutManager = GridLayoutManager(this, 2)
        } else {
            git2.layoutManager = LinearLayoutManager(this)
        }
        val listHeroAdapter = ListHeroAdapter(list)
        git2.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedUser(data)
            }
        })
    }
}
