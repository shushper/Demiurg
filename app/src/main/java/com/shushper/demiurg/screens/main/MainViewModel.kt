package com.shushper.demiurg.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.shushper.demiurg.cell.Cell
import com.shushper.demiurg.cell.CellManager

class MainViewModel(val handle: SavedStateHandle, private val cellManager: CellManager) :
    ViewModel() {


    private val cellsLiveData = MutableLiveData<List<Cell>>()
    val cells: LiveData<List<Cell>>
        get() = cellsLiveData


    fun onCrateBtnClick() {
        cellManager.createNewCell()
        cellsLiveData.value = cellManager.getCells()
    }

}