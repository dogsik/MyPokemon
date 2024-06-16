package com.example.mypokemon.Repository

import com.example.mypokemon.ModelData.Pokemon
import com.example.mypokemon.R

object PokemonRepository {
    private val pokemons: Map<Int, Pokemon> = listOf(
        Pokemon(
            id = 1,
            name = "Squirtle",
            weight = 90,
            height = 5,
            elementalType = listOf("Water"),
            picture = R.drawable.squirtle
        )
    ).associateBy { it.id }

    fun getAllPokemons(): Collection<Pokemon> {
        return pokemons.values
    }

    fun getPokemonById(id: Int): Pokemon? {
        return pokemons[id]
    }
}
