package dev.rj3.app.piccie

import android.app.Application
import timber.log.Timber

class PiccieApp : Application() {


    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

    }
}