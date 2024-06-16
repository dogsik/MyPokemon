package com.example.mypokemon.Activity

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

import com.example.mypokemon.Repository.PokemonRepository
import com.example.mypokemon.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonId = intent.extras?.getInt("pokemon_id", -1) ?: -1
        if (pokemonId != -1) {
            val pokemon = PokemonRepository.getPokemonById(pokemonId)
            if (pokemon != null) {
                binding.apply {
                    pokemonImageView.setImageResource(pokemon.picture)
                    pokemonNameTextView.text = pokemon.name
                    pokemonWeightTextView.text = pokemon.weight.toString()
                    pokemonHeightTextView.text = pokemon.height.toString()
                    pokemonTypeListView.adapter = ArrayAdapter(
                        this@DetailsActivity,
                        android.R.layout.simple_list_item_1,
                        pokemon.elementalType
                    )
                    backBtn.setOnClickListener { finish() }
                }
            } else {
                showErrorAndFinish("Pokemon with id not exist")
            }
        } else {
            showErrorAndFinish("Invalid id")
        }
    }

    private fun showErrorAndFinish(errorMessage: String) {
        Toast.makeText(this, "Unknown error. Try again later", Toast.LENGTH_SHORT).show()
        Log.e("mainPage", errorMessage)
        finish()
    }
}
