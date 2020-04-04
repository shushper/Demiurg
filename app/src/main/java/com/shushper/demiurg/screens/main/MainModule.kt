package com.shushper.demiurg.screens.main

import com.shushper.demiurg.cell.CellGenerator
import com.shushper.demiurg.cell.CellManager
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory { CellGenerator() }
    factory { CellManager(get()) }
    factory { CellsAdapter() }
    viewModel { MainViewModel(get()) }
}