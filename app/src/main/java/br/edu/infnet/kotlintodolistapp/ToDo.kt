package br.edu.infnet.kotlintodolistapp

data class ToDo(
    val title: String,
    val date: String,
    var isChecked: Boolean = false
)