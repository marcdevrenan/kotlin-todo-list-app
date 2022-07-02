package br.edu.infnet.kotlintodolistapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ToDoViewModel: ViewModel() {
    private val tipList : List<String> = listOf(
        "Do laundry",
        "Do homework",
        "Go shopping",
        "Pay your bills",
        "Clean house"
    )

    private val getToDoList = MutableLiveData<String>()
    val getToDos : LiveData<String>
    get() = getToDoList

    private fun randomList() {
        getToDoList.value = tipList.random()
    }

    init {
        randomList()
    }
}