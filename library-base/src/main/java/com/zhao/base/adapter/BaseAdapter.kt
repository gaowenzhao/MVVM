package com.zhao.base.adapter

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableArrayList
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


abstract class BaseAdapter<E>(var datas: ObservableArrayList<E> = ObservableArrayList()):ObservableAdapter<E>(datas),MutableList<E> by datas{
    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(vh: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        datas[position]?.let {
            (vh as BaseViewHolder<ViewDataBinding, BaseObservable>).initData(it as Any)
        }
    }
    open fun update(list:ObservableArrayList<E>){
        datas.clear()
        datas.addAll(list)
    }
}