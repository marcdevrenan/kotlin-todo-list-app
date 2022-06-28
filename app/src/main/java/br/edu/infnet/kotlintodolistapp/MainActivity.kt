package br.edu.infnet.kotlintodolistapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private lateinit var toDoSource: ToDoSource

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toDoSource = ToDoSource(mutableListOf())

        rvToDoItems.adapter = toDoSource
        rvToDoItems.layoutManager = LinearLayoutManager(this)

        val current = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("dd/MM")
        val toDoDate = current.format(formatter)

        btnAddItem.setOnClickListener {
            val toDoTitle = etToDoTitle.text.toString()
            if (toDoTitle.isNotEmpty()) {
                val toDo = ToDo(toDoTitle, toDoDate.toString())
                toDoSource.addItem(toDo)
                etToDoTitle.text.clear()
            }
        }

        btnDelItem.setOnClickListener {
            toDoSource.deleteItem()
        }

        btnBack.setOnClickListener {
            val intent = Intent(this, IntroActivity::class.java)
            startActivity(intent)
        }
    }
}