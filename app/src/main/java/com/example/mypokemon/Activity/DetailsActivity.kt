package com.example.mypokemon.Activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mypokemon.Repository.PokemonRepository
import com.example.mypokemon.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonId = intent.extras?.getInt("pokemon_id", -1) ?: -1

        with(binding) {
            if (pokemonId == -1) {
                Toast.makeText(this@DetailsActivity, "Invalid id", Toast.LENGTH_SHORT).show()
                finish()
                return@with
            }

            PokemonRepository.getPokemonById(pokemonId)?.let { pokemon ->
                pokemonImageView.setImageResource(pokemon.picture)
                pokemonNameTextView.text = pokemon.name
                pokemonWeightTextView.text = pokemon.weight.toString()
                pokemonHeightTextView.text = pokemon.height.toString()
                pokemonTypeTextView.text = pokemon.elementalType.joinToString(", ")

                backBtn.setOnClickListener { finish() }
            } ?: showErrorAndFinish("Pokemon with id does not exist")
        }

    }

    private fun showErrorAndFinish(errorMessage: String) {
        Toast.makeText(this, "Unknown error. Try again later", Toast.LENGTH_SHORT).show()
        Log.e("DetailsActivity", errorMessage)
        finish()
    }
}
