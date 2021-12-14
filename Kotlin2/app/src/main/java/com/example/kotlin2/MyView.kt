package com.example.kotlin2

import com.example.kotlin2.data.Word

interface MyView {
    fun updateRecyclerView(list: MutableList<Word>)
    fun showAlertForAddNewWord()
    fun showAlertForEditWord(word: Word)
}