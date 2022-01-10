package com.ortudev.sportsResults.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ortudev.sportsResults.R
import com.ortudev.sportsResults.data.domain.Circuit
import com.ortudev.sportsResults.databinding.ActivityDetailBinding
import com.ortudev.sportsResults.databinding.ActivityMainBinding
import com.ortudev.sportsResults.loadUrl
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_ID = "DetailActivity:id"
    }
    private val viewModel:DetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val circuitId = intent.getIntExtra(EXTRA_ID,-1)
        viewModel.getInfoCircuit(circuitId)

        viewModel.circuit.observe(this,::setInfoCircuit)
    }

    private fun setInfoCircuit(circuit:Circuit){
        with(binding){
            circuit.location?.let{
                country.text = it.country
                city.text = "(${it.city})"
            }
            length.text = circuit.length
            name.text = circuit.name
            track.loadUrl(circuit.image)
            circuit.loadFlag()?.let { countryFlag.loadUrl(it) }
        }
    }

}