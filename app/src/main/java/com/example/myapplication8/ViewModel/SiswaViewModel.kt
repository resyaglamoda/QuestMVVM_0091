package com.example.myarsitekturmvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myarsitekturmvm.model.Siswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SiswaViewModel : ViewModel() {
    private val _statusUI = MutableStateFlow(Siswa())
    val statusUI: StateFlow<Siswa> = _statusUI.asStateFlow()

    fun setSiswa(ls: MutableList<String>) {
        _statusUI.value = Siswa(
            nama = ls[0],
            gender = ls[1],
            alamat = ls[2]
        )
    }
}
