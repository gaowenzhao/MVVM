package com.zhao.base.adapter

import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView


abstract class ObservableAdapter<E>(var datas: ObservableArrayList<E>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    init {
        addOnListChangedCallback()
    }
    fun addOnListChangedCallback(){
        datas.addOnListChangedCallback(ListChangedListener<E>(this))
    }
}