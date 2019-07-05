package com.zhao.base.adapter

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView


class ListChangedListener<E>(val adapter: androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>) : ObservableList.OnListChangedCallback<ObservableArrayList<E>>() {
    //======================= main ============================
    override fun onChanged(sender: ObservableArrayList<E>?) {
        adapter.notifyDataSetChanged()
    }

    override fun onItemRangeRemoved(sender: ObservableArrayList<E>?, positionStart: Int, itemCount: Int) {
        adapter.notifyItemRangeRemoved(positionStart, itemCount)
    }

    override fun onItemRangeMoved(sender: ObservableArrayList<E>?, fromPosition: Int, toPosition: Int, itemCount: Int) {
        if (itemCount == 1) {
            adapter.notifyItemMoved(fromPosition, toPosition)
        }
        else {
            adapter.notifyDataSetChanged()
        }
    }

    override fun onItemRangeInserted(sender: ObservableArrayList<E>?, positionStart: Int, itemCount: Int) {
        adapter.notifyItemRangeInserted(positionStart, itemCount)
    }

    override fun onItemRangeChanged(sender: ObservableArrayList<E>?, positionStart: Int, itemCount: Int) {
        adapter.notifyItemRangeChanged(positionStart, itemCount)
    }
}