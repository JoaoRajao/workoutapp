package com.example.workoutapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.workoutapp.dao.TreinoDao
import com.example.workoutapp.dao.ExercicioDao
import com.example.workoutapp.model.Treino
import com.example.workoutapp.model.Exercicio

@Database(entities = [Treino::class, Exercicio::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun treinoDao(): TreinoDao
    abstract fun exercicioDao(): ExercicioDao
}
