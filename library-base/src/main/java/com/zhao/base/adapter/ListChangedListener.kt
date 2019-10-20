package com.zhao.base.adapter

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView


open class ListChangedListener<E>(val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) : ObservableList.OnListChangedCallback<ObservableArrayList<E>>() {
    //======================= main ============================
    override fun onChanged(sender: ObservableArrayList<E>?) {
        adapter.notifyDataSetChanged()
        Log.i("ListChangedListener","onChanged")
    }

    override fun onItemRangeRemoved(sender: ObservableArrayList<E>?, positionStart: Int, itemCount: Int) {
        adapter.notifyItemRangeRemoved(positionStart, itemCount)
        Log.i("ListChangedListener","onItemRangeRemoved")
    }
    override fun onItemRangeMoved(sender: ObservableArrayList<E>?, fromPosition: Int, toPosition: Int, itemCount: Int) {
        if (itemCount == 1) {
            adapter.notifyItemMoved(fromPosition, toPosition)
        }
        else {
            adapter.notifyDataSetChanged()
        }
        Log.i("ListChangedListener","onItemRangeMoved")
    }

    override fun onItemRangeInserted(sender: ObservableArrayList<E>?, positionStart: Int, itemCount: Int) {
        adapter.notifyItemRangeInserted(positionStart, itemCount)
        Log.i("ListChangedListener","onItemRangeInserted")
    }

    override fun onItemRangeChanged(sender: ObservableArrayList<E>?, positionStart: Int, itemCount: Int) {
        adapter.notifyItemRangeChanged(positionStart, itemCount)
        Log.i("ListChangedListener","onItemRangeChanged")
    }
}