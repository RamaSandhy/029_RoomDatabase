package com.example.navigasidengandata.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl Siswa")
data class Siswa (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val nama : String,
    val alamat : String,
    val telepon : String
)
