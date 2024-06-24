package com.example.mypokemon.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemon.ModelData.Pokemon
import com.example.mypokemon.databinding.ItemPokemonBinding



class PokemonListAdapter : RecyclerView.Adapter<PokemonViewHolder>() {
    private var items = emptyList<Pokemon>()
    var onClick: (Pokemon) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun submit(newItems: List<Pokemon>) {
        val diffUtilCallback = PokemonDiffUtil(items, newItems)
        items = newItems
        DiffUtil.calculateDiff(diffUtilCallback).dispatchUpdatesTo(this)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }
}