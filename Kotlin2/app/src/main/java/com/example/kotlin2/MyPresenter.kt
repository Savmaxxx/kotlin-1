package com.example.kotlin2

import com.example.kotlin2.data.Repository
import com.example.kotlin2.data.Word
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class MyPresenter(_myView: MyView) {

    private val myView = _myView
    private val myRepository = Repository()

    fun onButtonAddNewWord() {
        myView.showAlertForAddNewWord()
    }

    fun loadDB() {
        CoroutineScope(Dispatchers.IO).launch {
            val newList = myRepository.loadDB()
            withContext(Main) {
                myView.updateRecyclerView(newList)
            }
        }
    }

    fun onButtonSaveWord(newWord: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val newList = myRepository.saveNewWord(newWord)
            withContext(Main) {
                myView.updateRecyclerView(newList)
            }
        }

    }

    fun onButtonRemoveWord(position: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val newList = myRepository.removeWord(position)
            withContext(Main) {
                myView.updateRecyclerView(newList)
            }

        }
    }

    fun onButtonEditWord(position: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val word:Word=myRepository.getWord(position)
            withContext(Main){
                myView.showAlertForEditWord(word)
            }

        }

    }

    fun onButtonSaveEditWord(word: Word) {
CoroutineScope(Dispatchers.IO).launch {
    val list: MutableList<Word> =myRepository.upDataBD(word)
    withContext(Main){
        myView.updateRecyclerView(list)
    }
}
    }
}








