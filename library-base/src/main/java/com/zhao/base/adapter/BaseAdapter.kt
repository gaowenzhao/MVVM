package com.zhao.base.adapter

import android.databinding.BaseObservable
import android.databinding.ObservableArrayList
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

abstract class BaseAdapter<E>(var datas: ObservableArrayList<E> = ObservableArrayList()):ObservableAdapter<E>(datas),MutableList<E> by datas{
    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(vh: RecyclerView.ViewHolder, position: Int) {
        datas[position]?.let {
            (vh as BaseViewHolder<ViewDataBinding,BaseObservable>).initData(it as Any)
        }
    }
    open fun update(list:ObservableArrayList<E>){
        datas.clear()
        datas.addAll(list)
    }
}