package com.example.myarsitekturmvm.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myarsitekturmvm.R
import com.example.myarsitekturmvm.model.Siswa

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    statusUiSiswa: Siswa,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        Pair(stringResource(R.string.nama), statusUiSiswa.nama),
        Pair(stringResource(id = R.string.gender), statusUiSiswa.gender),
        Pair(stringResource(id = R.string.alamat), statusUiSiswa.alamat)
    )
