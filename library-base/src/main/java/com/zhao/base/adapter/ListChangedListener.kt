package com.zhao.base.adapter

import android.databinding.ObservableArrayList
import android.databinding.ObservableList
import android.support.v7.widget.RecyclerView

class ListChangedListener<E>(val adapter:RecyclerView.Adapter<RecyclerView.ViewHolder>) : ObservableList.OnListChangedCallback<ObservableArrayList<E>>() {
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