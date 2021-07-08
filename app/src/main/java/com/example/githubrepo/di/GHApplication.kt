package com.example.githubrepo.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GHApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(domainModules)
            modules(dataModules)
            modules(networkModules)
            modules(presentationModules)
        }
    }
}