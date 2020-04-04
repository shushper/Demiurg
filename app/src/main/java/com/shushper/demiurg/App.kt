package com.shushper.demiurg

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import com.shushper.demiurg.cell.CellGenerator
import com.shushper.demiurg.cell.CellManager
import com.shushper.demiurg.screens.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class App : Application() {

    private val appModule = module {
        single { CellGenerator() }
        single { CellManager(get()) }
        viewModel { (handle: SavedStateHandle) ->
            MainViewModel(
                handle,
                get()
            )
        }
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }

}

