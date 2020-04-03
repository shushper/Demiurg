package com.shushper.demiurg

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    init {
        Log.d("MainViewModel", "init")
    }

    fun onCreateClick() {
        Log.d("MainViewModel", "onCreateClick")
    }

}