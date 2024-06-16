package com.example.mypokemon.ModelData

data class Pokemon(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val elementalType: List<String>,
    val picture: Int
)
