package com.aragh.kotlin1

import android.app.Application
import com.aragh.kotlin1.di.AppModule
import org.koin.android.ext.android.startAndroidContext


class TheApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    startAndroidContext(this, AppModule())
  }
}