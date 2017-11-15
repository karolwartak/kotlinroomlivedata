package com.aragh.kotlin1.list

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.widget.EditText
import com.aragh.kotlin1.R
import com.aragh.kotlin1.data.Item
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.content_list.*
import org.koin.android.ext.android.inject

class ListActivity : AppCompatActivity() {

  private val viewModel: ListViewModel by inject()
  private var items: List<Item> = ArrayList()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list)
    setSupportActionBar(toolbar)

    recycler.layoutManager = LinearLayoutManager(this)
    recycler.adapter = ItemsAdapter(items) {
      item -> Snackbar.make(recycler, item.id, Snackbar.LENGTH_SHORT).show()
    }

    val nameInput : EditText = LayoutInflater.from(this).inflate(R.layout.dialog_new, recycler, false) as EditText
    val newDialog = AlertDialog.Builder(this)
        .setView(nameInput)
        .setPositiveButton("Create") { dialogInterface, _ ->
          dialogInterface.dismiss()
          viewModel.addItem(nameInput.text.toString())
          nameInput.text.clear()
        }
        .create()

    fab.setOnClickListener { _ ->
      newDialog.show()
    }
  }

  override fun onStart() {
    super.onStart()
    viewModel.getItems().observe(this, Observer {
      items = it!!
      recycler.adapter.notifyDataSetChanged()
    })
  }
}
