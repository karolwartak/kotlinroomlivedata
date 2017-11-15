package com.aragh.kotlin1.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase


@Database(version = 1, entities = arrayOf(Item::class))
abstract class AppDatabase : RoomDatabase() {

  abstract fun itemsDao(): ItemsDao

}