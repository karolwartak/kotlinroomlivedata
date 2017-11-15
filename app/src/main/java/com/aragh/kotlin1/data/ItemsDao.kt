package com.aragh.kotlin1.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query


@Dao
interface ItemsDao {

  @Query("SELECT * FROM items")
  fun getAllItems(): LiveData<List<Item>>

  @Query("SELECT * FROM items WHERE id = :itemId")
  fun getItem(itemId: String): LiveData<Item>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(item: Item)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertAll(vararg items: Item)

  @Delete
  fun delete(item: Item)

}
