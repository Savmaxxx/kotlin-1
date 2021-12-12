package com.example.kotlin2.data

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Word(_newWord: String) {
    @PrimaryKey
    @NonNull
    var newWord = _newWord

}