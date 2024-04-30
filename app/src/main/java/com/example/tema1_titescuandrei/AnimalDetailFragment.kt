package com.example.tema1_titescuandrei

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnimalDetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.display_animal_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameTextView = view.findViewById<TextView>(R.id.tv_animal_name)
        val continentTextView = view.findViewById<TextView>(R.id.tv_animal_continent)

        // Primim argumentele trimise către fragment
        val args = arguments
        if (args != null) {
            val animalName = args.getString("animalName")
            val animalContinent = args.getString("animalContinent")
            val animalColor = args.getInt("Color")

            nameTextView.text = animalName
            continentTextView.text = animalContinent

            view.setBackgroundColor(animalColor)
        }
    }
}
