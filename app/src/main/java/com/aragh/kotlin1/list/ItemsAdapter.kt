package com.aragh.kotlin1.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.aragh.kotlin1.R
import com.aragh.kotlin1.data.Item
import com.aragh.kotlin1.extensions.inflate
import kotlinx.android.synthetic.main.view_item.view.*


class ItemsAdapter(private val items : List<Item>,
                   private val clickListener: (Item) -> Unit)
  : RecyclerView.Adapter<ItemViewHolder>() {

  override fun onBindViewHolder(holder: ItemViewHolder, position: Int) =
      holder.bind(items[position], clickListener)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
      ItemViewHolder(parent.inflate(R.layout.view_item))

  override fun getItemCount() = items.size

}

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  fun bind(item: Item, listener: (Item) -> Unit) = with(itemView) {
    textView.text = item.name
    setOnClickListener { listener(item) }
  }

}