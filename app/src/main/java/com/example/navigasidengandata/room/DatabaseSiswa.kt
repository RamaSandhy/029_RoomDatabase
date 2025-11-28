package com.example.roomdatabase.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.navigasidengandata.room.Siswa
import com.example.navigasidengandata.room.SiswaDao

@Database(entities = [Siswa::class], version = 1, exportSchema = false)
abstract class DatabaseSiswa : RoomDataBase() {
    abstract fun siswaDao() : SiswaDao

    companion object {
        @Volatile
        private var Instance: DatabaseSiswa? = null

        fun getDataBase(context: Context): DatabaseSiswa {
            return (Instance?: synchronized(this){
                Room.DatabaseBuilder(
                    context, DatabaseSiswa::class.java,
                    "Siswa_Database")
                    .build().also { Instance=it }
            })
        }
    }
}