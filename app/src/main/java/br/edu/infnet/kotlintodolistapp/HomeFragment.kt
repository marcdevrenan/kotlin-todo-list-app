package br.edu.infnet.kotlintodolistapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val userName = view.findViewById<EditText>(R.id.etUserName)
        val userEmail = view.findViewById<EditText>(R.id.etUserEmail)
        val start_button = view.findViewById<Button>(R.id.start_button)

        start_button.setOnClickListener {
            val bundle = bundleOf("name" to userName.text.toString())
            findNavController().navigate(R.id.action_homeFragment_to_introFragment, bundle)
        }

        return view
    }
}