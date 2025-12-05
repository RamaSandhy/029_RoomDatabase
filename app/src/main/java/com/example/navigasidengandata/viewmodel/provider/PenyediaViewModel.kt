package com.example.navigasidengandata.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            val repositorySiswa =
                (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)
                    .container
                    .repositorySiswa

            EntryViewModel(repositorySiswa = repositorySiswa)
        }


        initializer {
            val repositorySiswa =
                (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)
                    .container
                    .repositorySiswa

            EditViewModel(repositorySiswa = repositorySiswa)
        }
    }
}

