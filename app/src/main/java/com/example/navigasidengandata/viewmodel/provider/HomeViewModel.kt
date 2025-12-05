package com.example.navigasidengandata.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigasidengandata.repositori.RepositoriSiswa
import com.example.navigasidengandata.room.Siswa
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.SharingStarted

class HomeViewModel(private val repositoriSiswa: RepositoriSiswa) : ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val homeUiState: StateFlow<HomeUiState> =
        repositoriSiswa.getAllSiswaStream()
            .filterNotNull()
            .map { HomeUiState(listSiswa = it.toList()) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )

    data class HomeUiState(
        val listSiswa: List<Siswa> = listOf()
    )
}