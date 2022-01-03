package com.ortudev.sportsResults.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ortudev.sportsResults.R
import com.ortudev.sportsResults.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    private val adapter: CircuitsAdapter by lazy {
        CircuitsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Circuits"
        with(binding){
            recycler.layoutManager = LinearLayoutManager(this@MainActivity)
            recycler.adapter = adapter

            viewModel.circuits.observe(this@MainActivity,{ list ->
                list?.let{it ->adapter.items = it}
            })
            viewModel.refreshing.observe(this@MainActivity,{ refreshing ->
                reload.isRefreshing = refreshing
            })
            reload.setOnRefreshListener {
                viewModel.onReloadCircuits()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       val filter = when(item.itemId){
            R.id.filter_ascending -> Filter.Ascending
            else -> Filter.Descending
        }
        viewModel.filterItems(filter)
        return super.onOptionsItemSelected(item)
    }

}