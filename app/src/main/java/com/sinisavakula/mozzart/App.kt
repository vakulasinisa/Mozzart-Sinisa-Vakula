package com.sinisavakula.mozzart

import android.app.Application
import com.sinisavakula.mozzart.di.OkHttpModule
import com.sinisavakula.mozzart.di.ViewModelModule
import com.sinisavakula.mozzart.di.RetrofitModule
import com.sinisavakula.mozzart.di.RepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupDependencies()
    }

    private fun setupDependencies() {
        startKoin {
            androidContext(this@App)
            modules(
                ViewModelModule,
                RetrofitModule,
                RepositoryModule,
                OkHttpModule
            )
        }
    }
}
