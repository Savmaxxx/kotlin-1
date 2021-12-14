package com.example.kotlin2.data

import com.example.kotlin2.App

class Repository {
    private val appDataBase: AppDataBase = App.getAppDataBase()

    fun saveNewWord(newWord: String): MutableList<Word> {
        appDataBase.getWordDao().insert(Word(newWord))
        return appDataBase.getWordDao().getWord()
    }

    fun loadDB() = appDataBase.getWordDao().getWord()

    fun removeWord(position: Int): MutableList<Word> {
        appDataBase.getWordDao().delete(appDataBase.getWordDao().getWord()[position])
        return appDataBase.getWordDao().getWord()
    }

    fun getWord(position: Int) = appDataBase.getWordDao().getWord()[position]

    fun upDataBD(word: Word): MutableList<Word> {
        appDataBase.getWordDao().update(word)
        return appDataBase.getWordDao().getWord()
    }
}