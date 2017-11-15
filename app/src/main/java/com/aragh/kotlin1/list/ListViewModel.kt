package com.aragh.kotlin1.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.aragh.kotlin1.data.Item
import com.aragh.kotlin1.data.ItemsDao
import io.reactivex.Completable
import java.util.*


class ListViewModel(private val itemsDao: ItemsDao) : ViewModel() {

  fun getItems(): LiveData<List<Item>> {
    return itemsDao.getAllItems()
  }

  fun addItem(name: String): Completable {
    return Completable.fromAction {
      itemsDao.insert(Item(UUID.randomUUID().toString(), name))
    }
  }

}