package com.example.kotlin2.data

import androidx.room.*

@Dao
interface WordDao {
    @Insert
    fun insert(word: Word)

    @Delete
    fun delete(word: Word)

    @Update
    fun update(word: Word)

    @Query("SELECT*FROM Word")
    fun getWord(): MutableList<Word>

}