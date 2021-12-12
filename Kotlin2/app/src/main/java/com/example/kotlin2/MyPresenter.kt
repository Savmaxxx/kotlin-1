package com.example.kotlin2

import com.example.kotlin2.data.Repository
import com.example.kotlin2.data.Word
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class MyPresenter(_myView: MyView) {
    private val myView = _myView
    private val myRepository = Repository()

    fun onButtonAddNewWord() {
        myView.showAlertForAddNewWord()
    }


    suspend fun onButtonSaveWord(newWord: String) = coroutineScope {

        val newList: Deferred<MutableList<Word>> = async { myRepository.saveNewWord(newWord) }
        myView.updateRecyclerView(newList.await())

    }

}

