package com.example.kotlin2.data

import com.example.kotlin2.App

class Repository {
    private val appDataBase: AppDataBase = App().getAppDataBase()
//    private lateinit var listWords: MutableList<Word>

    fun saveNewWord(newWord: String): MutableList<Word> {
        appDataBase.getWordDao().insert(Word(newWord))
       return appDataBase.getWordDao().getWord()
    }
}