package com.zhao.base.adapter

import androidx.databinding.ObservableArrayList


abstract class ObservableAdapter<E>(datas: ObservableArrayList<E>): androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>(){
    init {
        datas.addOnListChangedCallback(createListChangedListener())
    }
    private fun createListChangedListener():ListChangedListener<E>{
       return ListChangedListener(this)
    }
}