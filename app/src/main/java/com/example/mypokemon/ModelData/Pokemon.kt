package com.example.mypokemon.ModelData

import androidx.annotation.DrawableRes

data class Pokemon(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val elementalType: List<String>,
    @DrawableRes
    val picture: Int
)
