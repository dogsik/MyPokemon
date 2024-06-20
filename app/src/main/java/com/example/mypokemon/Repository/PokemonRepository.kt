package com.example.mypokemon.Repository

import com.example.mypokemon.ModelData.Pokemon
import com.example.mypokemon.R

object PokemonRepository {
    private val pokemons: HashMap<Int, Pokemon> = hashMapOf(
        1 to Pokemon(
            id = 1,
            name = "Squirtle",
            weight = 90,
            height = 5,
            elementalType = listOf("Water"),
            picture = R.drawable.squirtle
        )
    )

    fun getAllPokemons() = pokemons.values

    fun getPokemonById(id: Int) = pokemons[id]
}
