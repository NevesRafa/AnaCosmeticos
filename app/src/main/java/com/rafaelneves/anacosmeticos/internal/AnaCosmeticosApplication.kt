package com.rafaelneves.anacosmeticos.internal

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AnaCosmeticosApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AnaCosmeticosApplication)
            modules(appModule)
        }
    }
}