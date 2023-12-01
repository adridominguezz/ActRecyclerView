package com.example.actrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PokemonAdapter(private val pokemonList: List<Pokemon>) :
    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    private var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int)
        fun onImageClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val currentItem = pokemonList[position]

        holder.pokemonName.text = currentItem.nombre
        holder.pokemonHeight.text = currentItem.altura
        holder.pokemonWeight.text = currentItem.peso
        holder.pokemonNumber.text = currentItem.numeroIdentificacion.toString()

        // Establecer la imagen del Pokémon en el ImageView
        holder.pokemonImage.setImageResource(currentItem.imagen)

        holder.itemView.setOnClickListener {
            listener?.onItemClick(position)
        }

        holder.pokemonImage.setOnClickListener {
            listener?.onImageClick(position)
        }
    }

    override fun getItemCount() = pokemonList.size

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pokemonName: TextView = itemView.findViewById(R.id.txtPokemonName)
        val pokemonHeight: TextView = itemView.findViewById(R.id.txtPokemonHeight)
        val pokemonWeight: TextView = itemView.findViewById(R.id.txtPokemonWeight)
        val pokemonNumber: TextView = itemView.findViewById(R.id.txtPokemonNumber)
        val pokemonImage: ImageView = itemView.findViewById(R.id.imgPokemon)
    }
}
