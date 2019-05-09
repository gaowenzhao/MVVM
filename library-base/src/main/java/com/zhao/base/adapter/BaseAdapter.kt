package com.zhao.base.adapter

import android.databinding.ObservableArrayList
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.zhao.base.adapter.multityppe.MultiItemEntity
import com.zhao.base.inf.BaseVM

abstract class BaseAdapter<E>(var datas: ObservableArrayList<E> = ObservableArrayList()):ObservableAdapter<E>(datas),MutableList<E> by datas{
    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(vh: RecyclerView.ViewHolder, position: Int) {
        (vh as BaseViewHolder<ViewDataBinding>).bindData(datas[position] as BaseVM)
    }
    open fun update(list:ObservableArrayList<E>){
        datas.clear()
        datas.addAll(list)
    }
}