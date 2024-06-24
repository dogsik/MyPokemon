package com.example.mypokemon.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.mypokemon.Repository.PokemonRepository
import com.example.mypokemon.databinding.ActivityMainBinding
import com.example.mypokemon.recycler.PokemonListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PokemonListAdapter()
        adapter.onClick = { pokemon ->
            Log.d("MainActivity", "Clicked on: ${pokemon.name}")
            val intent = Intent(this@MainActivity, DetailsActivity::class.java).apply {
                putExtra("pokemon_id", pokemon.id)
            }
            startActivity(intent)
        }
        binding.recycler.adapter = adapter

        val pokemonList = PokemonRepository.getAllPokemons()
        Log.d("MainActivity", "Pokemon list loaded with ${pokemonList.size} items")
        adapter.submit(pokemonList)
        binding.recycler.addItemDecoration(DividerItemDecoration(this, VERTICAL))
    }
}
