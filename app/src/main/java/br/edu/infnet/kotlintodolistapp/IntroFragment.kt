package br.edu.infnet.kotlintodolistapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class IntroFragment : Fragment() {
    lateinit var tipViewModel : ToDoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_intro, container, false)
        val userName = view.findViewById<TextView>(R.id.intro_text)
        val name = arguments?.getString("name")
        val randomTip = view.findViewById<TextView>(R.id.random_tip_text)
        val open_list_button = view.findViewById<Button>(R.id.open_list_button)
        val about_button = view.findViewById<Button>(R.id.about_button)

        tipViewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
        tipViewModel.getToDos.observe(viewLifecycleOwner) { tip ->
            randomTip.text = tip
        }

        userName.text ="Hello, $name"

        open_list_button.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment_to_mainActivity)
        }

        about_button.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment_to_aboutFragment)
        }

        return view
    }
}