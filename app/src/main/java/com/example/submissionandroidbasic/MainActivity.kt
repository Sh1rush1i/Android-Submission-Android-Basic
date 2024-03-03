package com.example.submissionandroidbasic

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFruit: RecyclerView
    private val list = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFruit = findViewById(R.id.rv_fruit)
        rvFruit.setHasFixedSize(true)

        list.addAll(getListFruit())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvFruit.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvFruit.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListFruit(): ArrayList<Fruit> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_preview)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listFruit = ArrayList<Fruit>()
        for (i in dataName.indices) {
            val fruit = Fruit(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listFruit.add(fruit)
        }
        return listFruit
    }

    private fun showRecyclerList() {
        rvFruit.layoutManager = LinearLayoutManager(this)
        val listFruitAdapter = ListFruitAdapter(list)
        rvFruit.adapter = listFruitAdapter
    }
}