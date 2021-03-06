package com.example.a4aprojetahratina.injection

import android.app.Application
import com.example.a4aprojetahratina.dataModule
import com.example.a4aprojetahratina.domainModule
import com.example.a4aprojetahratina.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EsieaApplication : Application() {
    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin {
            // Android context
            androidContext(this@EsieaApplication)
            // modules
            modules(presentationModule, domainModule, dataModule)
        }
    }
}