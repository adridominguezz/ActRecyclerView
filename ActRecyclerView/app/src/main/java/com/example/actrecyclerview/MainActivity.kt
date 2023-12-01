package com.example.actrecyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var pokemonAdapter: PokemonAdapter
    private lateinit var pokemonList: ArrayList<Pokemon>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        pokemonList = ArrayList()

        pokemonList.add(Pokemon("Pikachu", R.drawable.pikachu, "0.4 m", "6.0 kg", 1))
        pokemonList.add(Pokemon("Eevee", R.drawable.eevee, "0.5 m", "7.0 kg", 25))
        pokemonList.add(Pokemon("Bulbasur", R.drawable.bulbasur, "0.75 m", "10.0 kg", 12))
        pokemonList.add(Pokemon("Charizard", R.drawable.charizard, "2 m", "60.0 kg", 5))
        pokemonList.add(Pokemon("Lucario", R.drawable.lucario, "1.4 m", "45.0 kg", 38))



        // Configurar RecyclerView
        recyclerView = findViewById(R.id.pokemon_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        pokemonAdapter = PokemonAdapter(pokemonList)
        recyclerView.adapter = pokemonAdapter

        pokemonAdapter.setOnItemClickListener(object : PokemonAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(this@MainActivity, "Pokemon pulsado", Toast.LENGTH_SHORT).show()
            }

            override fun onImageClick(position: Int) {
                TODO("Not yet implemented")
            }

        })
    }

}