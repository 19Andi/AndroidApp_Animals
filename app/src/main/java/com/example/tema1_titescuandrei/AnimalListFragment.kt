package com.example.tema1_titescuandrei

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tema1_titescuandrei.adapters.AnimalListAdapter
import com.example.tema1_titescuandrei.models.Animal

class AnimalListFragment : Fragment() {
    private val animalList = ArrayList<Animal>()
    private val adapter = AnimalListAdapter(animalList)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.scroll_list_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAnimalList()
    }

    private fun setupAnimalList() {
        val layoutManager = LinearLayoutManager(context)

        view?.findViewById<RecyclerView>(R.id.rv_animal_list)?.apply {
            this.layoutManager = layoutManager
            this.adapter = this@AnimalListFragment.adapter
        }
        generateAnimalList()
    }

    private fun generateAnimalList() {
        val animalsByContinent = arrayOf( Animal("Wolf", "Europe"),
            Animal("Panda", "Asia"), Animal("Hippopotamus", "Africa"),
            Animal("Bald Eagle", "North America"),Animal("Llama", "South America"),
            Animal("Crocodile", "North America"), Animal("Giraffe", "Africa"),
            Animal("Condor", "South America"), Animal("Kangaroo", "Australia"),
            Animal("Komodo", "Asia"), Animal("Koala", "Australia"),
            Animal("Penguin", "Antarctica"), Animal("Seal", "Antarctica"),
            Animal("Squirrel", "Europe")
        )

        animalList.addAll(animalsByContinent)

        while (animalList.size < 50) {
            val randomAnimal = animalsByContinent.random()
            animalList.add(randomAnimal)
        }
    }
}