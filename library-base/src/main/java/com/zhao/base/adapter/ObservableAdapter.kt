package com.zhao.base.adapter

import android.databinding.ObservableArrayList
import android.support.v7.widget.RecyclerView


abstract class ObservableAdapter<E>(datas: ObservableArrayList<E>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    init {
        datas.addOnListChangedCallback(createListChangedListener())
    }
    private fun createListChangedListener():ListChangedListener<E>{
       return ListChangedListener(this)
    }
}