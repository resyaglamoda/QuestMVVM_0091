package com.example.myapplication8.view.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// Import disesuaikan dengan huruf besar/kecil folder di panel kiri kamu
import com.example.myapplication8.Model.DataJK
import com.example.myapplication8.view.FormSiswa
import com.example.myapplication8.view.TampilSiswa
import com.example.myapplication8.ViewModel.SiswaViewModel

enum class Navigasi {
    Formulir,
    Detail
}

@Composable
fun SiswaApp(
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    // PERBAIKAN: Mengambil state dari ViewModel dengan cara yang benar (collectAsState)
    val statusUiSiswa by viewModel.statusUI.collectAsState()

    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            composable(route = Navigasi.Formulir.name) {
                val konteks = LocalContext.current
                FormSiswa(
                    pilihanJK = DataJK.JenisK.map { id -> konteks.resources.getString(id) },
                    onSubmitButtonClicked = { dataSiswa ->
                        viewModel.setSiswa(dataSiswa)
                        navController.navigate(Navigasi.Detail.name)
                    },
                    modifier = modifier
                )
            }

            composable(route = Navigasi.Detail.name) {
                TampilSiswa(
                    // PERBAIKAN: Panggil variabel statusUiSiswa yang sudah di-collect
                    statusUiSiswa = statusUiSiswa,
                    onBackButtonClicked = { cancelAndBackToFormulir(navController) },
                    modifier = modifier
                )
            }
        }
    }
}

private fun cancelAndBackToFormulir(navController: NavHostController) {
    navController.popBackStack(Navigasi.Formulir.name, inclusive = false)
}