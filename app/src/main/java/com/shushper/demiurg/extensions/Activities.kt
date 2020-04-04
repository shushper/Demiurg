package com.shushper.demiurg.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


fun <T> AppCompatActivity.observe(liveData: LiveData<T>, callback: (T) -> Unit) {
    liveData.observe(this, Observer {
        callback.invoke(it)
    })
}
