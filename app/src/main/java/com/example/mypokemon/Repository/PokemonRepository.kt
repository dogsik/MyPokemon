package com.example.mypokemon.Repository

import com.example.mypokemon.ModelData.Pokemon
import com.example.mypokemon.R

object PokemonRepository {
    private val pokemons: HashMap<Int, Pokemon> = hashMapOf(
        0 to Pokemon(
            id = 0,
            name = "Squirtle",
            weight = 90,
            height = 5,
            elementalType = listOf("Water"),
            picture = R.drawable.squirtle
        ),
        1 to
                Pokemon(
                    id = 1,
                    name = "Ivysaur",
                    weight = 130,
                    height = 10,
                    elementalType = listOf("Grass","Poison"),
                    picture = R.drawable.ivysaur
                ),
        2 to
                Pokemon(
                    id = 2,
                    name = "Venusaur",
                    weight = 1000,
                    height = 20,
                    elementalType = listOf("Grass","Poison"),
                    picture = R.drawable.venusaur
                )
    )


    fun getAllPokemons(): List<Pokemon> = pokemons.values.toList()

    fun getPokemonById(id: Int) = pokemons[id]
}
