package com.zhao.base.adapter

import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView


abstract class ObservableAdapter<E>(datas: ObservableArrayList<E>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    init {
        datas.addOnListChangedCallback(createListChangedListener())
    }
    private fun createListChangedListener():ListChangedListener<E>{
       return ListChangedListener(this)
    }
}