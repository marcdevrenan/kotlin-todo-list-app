package br.edu.infnet.kotlintodolistapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class AboutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        val help_button = view.findViewById<Button>(R.id.help_button)
        val rate_button = view.findViewById<Button>(R.id.rate_button)

        help_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://kotlinlang.org/")
            startActivity(intent)
        }

        rate_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT, "Awesome Application!")
            val title = "Choose a share option"
            val chooser = Intent.createChooser(intent, title)
            startActivity(chooser)
        }

        return view
    }
}