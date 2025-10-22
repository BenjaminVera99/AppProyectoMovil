package com.example.appmovil.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("nombre")
    val nombre: String,
    @ColumnInfo("correo")
    val correo: String,
    @ColumnInfo("contraseña")
    val contrasena: String,
    @ColumnInfo("direccion")
    val direccion: String,

)