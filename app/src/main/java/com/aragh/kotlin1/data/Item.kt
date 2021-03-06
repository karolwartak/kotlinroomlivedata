package com.aragh.kotlin1.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "items")
data class Item(@PrimaryKey val id: String,
                val name: String)