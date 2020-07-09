package com.fghilmany.themoviedbwithjetpack

import android.app.Application
import com.fghilmany.themoviedbwithjetpack.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(Modules.appModule))
        }

    }
}