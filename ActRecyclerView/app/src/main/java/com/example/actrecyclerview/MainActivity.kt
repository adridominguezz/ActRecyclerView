package com.example.actrecyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        // Agregar datos de Pokémon (reemplaza con tus datos)
        pokemonList.add(Pokemon("Pikachu", R.drawable.pikachu, "0.4 m", "6.0 kg", 25))
        // Añade más Pokémon aquí...

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
                // Aquí abrirías otra página para ampliar la imagen
                // Puedes utilizar un Intent para abrir una nueva actividad
            }
        })
    }
}