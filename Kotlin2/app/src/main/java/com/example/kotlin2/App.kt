package com.example.kotlin2

import android.app.Application
import androidx.room.Room
import com.example.kotlin2.data.AppDataBase

class App : Application() {
    private lateinit var appDataBase: AppDataBase

    override fun onCreate() {
        super.onCreate()
        appDataBase = Room.databaseBuilder(this, AppDataBase::class.java, "app-database").build()

    }

    fun getAppDataBase(): AppDataBase = appDataBase


}