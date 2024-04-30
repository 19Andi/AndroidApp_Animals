package com.example.tema1_titescuandrei.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.tema1_titescuandrei.AnimalDetailFragment
import com.example.tema1_titescuandrei.R
import com.example.tema1_titescuandrei.models.Animal

class AnimalListAdapter(
    private val items: List<Animal>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AnimalViewHolder(
            inflater.inflate(R.layout.item_animal, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val animal = items[position]
        if (holder is AnimalViewHolder) {
            holder.bind(animal)
            holder.itemView.setBackgroundColor(animal.color.toInt())
            holder.itemView.setOnClickListener {
                val context = holder.itemView.context
                val fragment = AnimalDetailFragment()

                val args = Bundle()
                args.putString("animalName", animal.name)
                args.putString("animalContinent", animal.continent)
                args.putInt("Color", animal.color.toInt())
                fragment.arguments = args

                (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    inner class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.tv_animal_name)
        private val continentTextView: TextView = itemView.findViewById(R.id.tv_animal_continent)

        fun bind(animal: Animal) {
            nameTextView.text = animal.name
            continentTextView.text = animal.continent
        }
    }
}