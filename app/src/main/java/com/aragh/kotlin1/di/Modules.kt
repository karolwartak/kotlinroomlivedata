package com.aragh.kotlin1.di

import android.arch.persistence.room.Room
import com.aragh.kotlin1.data.AppDatabase
import com.aragh.kotlin1.list.ListViewModel
import org.koin.android.module.AndroidModule


class AppModule : AndroidModule() {
  override fun context() = applicationContext {

    provide { Room.databaseBuilder(context, AppDatabase::class.java, "db").build() }

    context("list") {
      provide { get<AppDatabase>().itemsDao() }
      provide { ListViewModel(get()) }
    }

  }
}