package com.example.mypokemon.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mypokemon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:  ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pokemonNameTextView.setOnClickListener {
            val intent = Intent(this@MainActivity, DetailsActivity::class.java).apply {
                putExtra("pokemon_id", 1)
            }
            startActivity(intent)
            Log.d("MainActivity", "Started DetailsActivity for pokemon_id: 1")
        }
    }
}
