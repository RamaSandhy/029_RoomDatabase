package com.example.navigasidengandata.repositori

import com.example.navigasidengandata.room.Siswa
import com.example.navigasidengandata.room.SiswaDao
import kotlinx.coroutines.flow.Flow


interface RepositorySiswa {

    fun getAllSiswaStream(): Flow<List<Siswa>>

    suspend fun insertSiswa(siswa: Siswa)
}

// Usage
class OfflineRepositorySiswa(
    private val siswaDao: SiswaDao
) : RepositorySiswa {

    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()

    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
}