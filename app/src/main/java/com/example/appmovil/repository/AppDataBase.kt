package com.example.appmovil.repository

import androidx.room.Database
import com.example.appmovil.model.Users

@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class AppDataBase(): RoomDataBase() {
    abstract fun userDao():UserDao
}