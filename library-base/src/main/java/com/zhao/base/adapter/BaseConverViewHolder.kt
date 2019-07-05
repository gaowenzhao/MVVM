package com.zhao.base.adapter

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseConverViewHolder<VDB : ViewDataBinding,T>(layoutId: Int, vg:ViewGroup): androidx.recyclerview.widget.RecyclerView.ViewHolder(LayoutInflater.from(vg.context).inflate(layoutId,vg,false)){
    var ui:VDB = DataBindingUtil.bind(itemView)!!

    abstract fun bindData(data: Any)
}