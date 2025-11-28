package com.example.roomdatabase.repositori

import android.content.Context
import com.example.navigasidengandata.repositori.RepositorySiswa
import com.example.roomdatabase.room.DatabaseSiswa

interface ContainerApp {
    val repositoriSiswa : RepositorySiswa
}

class ContainerDataApp(private val context: Context):
    ContainerApp {
    override val repositoriSiswa : RepositorySiswa by lazy {
        OfflineRepositoriSiswa(DatabaseSiswa. getDataBase(context).siswaDao())
    }
}


