package com.example.mypokemon.recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemon.ModelData.Pokemon
import com.example.mypokemon.databinding.ItemPokemonBinding


class PokemonViewHolder(
    private val binding: ItemPokemonBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(model: Pokemon, onClick: (Pokemon) -> Unit){
        binding.pokemonNameTextView.text = model.name
        binding.pokemonImageView.setImageResource(model.picture)
        binding.root.setOnClickListener{ onClick(model) }
    }
}