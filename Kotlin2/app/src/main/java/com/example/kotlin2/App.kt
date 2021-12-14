package com.example.kotlin2

import android.app.Application
import androidx.room.Room
import com.example.kotlin2.data.AppDataBase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appDataBase = Room.databaseBuilder(
            this,
            AppDataBase::class.java, "app-database"
        ).build()
    }

    companion object {
       private var appDataBase: AppDataBase? = null
            fun getAppDataBase():AppDataBase{
                return appDataBase!!
            }
    }
}