package com.ortudev.sportsResults.ui

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ortudev.sportsResults.R
import com.ortudev.sportsResults.data.domain.Circuit
import com.ortudev.sportsResults.databinding.CircuitItemBinding
import com.ortudev.sportsResults.inflate
import com.ortudev.sportsResults.loadUrl
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class CircuitsAdapter(items: List<Circuit> = emptyList()): RecyclerView.Adapter<CircuitsAdapter.ViewHolder>() {

    var items:List<Circuit> by Delegates.observable(items){_,_,_ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.circuit_item)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size


    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val binding = CircuitItemBinding.bind(view)
        @SuppressLint("SetTextI18n")
        fun bind(circuit: Circuit){
            with(binding){
                name.text = circuit.name + " (${circuit.location.country})"
                track.loadUrl(circuit.image)
            }
        }
    }
}