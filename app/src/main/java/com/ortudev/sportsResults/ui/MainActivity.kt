package com.ortudev.sportsResults.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ortudev.sportsResults.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel:MainViewModel by viewModel()
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

            mainViewModel.circuits.observe(this@MainActivity,{ list ->
                list?.let{it ->adapter.items = it}
            })
            mainViewModel.refreshing.observe(this@MainActivity,{ refreshing ->
                reload.isRefreshing = refreshing
            })
            reload.setOnRefreshListener {
                mainViewModel.onReloadCircuits()
            }
        }
    }
}