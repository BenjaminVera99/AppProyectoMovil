package com.example.appmovil.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.appmovil.model.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("Select * FROM users")
    fun obtenerUsuarios(): Flow<List<Users>>

    @Query("Select * FROM users WHERE id=:id")
    fun obtenerUsuarios(id: Int): Flow<Users>

    @Query("Select * FROM users WHERE correo=:correo")
    fun obtenerUsuarios(correo: String): Flow<Users>

    @Insert
    suspend fun agregarUsuario(user: Users)
    @Delete
    suspend fun eliminarUsuario(user: Users)
    @Update
    suspend fun actualizarUsuario(users: Users)
}