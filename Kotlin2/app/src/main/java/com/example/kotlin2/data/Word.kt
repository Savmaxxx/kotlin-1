package com.example.kotlin2.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")

data class Word(  var newWord: String) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0



}