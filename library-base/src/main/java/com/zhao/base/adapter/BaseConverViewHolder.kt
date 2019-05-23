package com.zhao.base.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseConverViewHolder<VDB : ViewDataBinding,T>(layoutId: Int, vg:ViewGroup): RecyclerView.ViewHolder(LayoutInflater.from(vg.context).inflate(layoutId,vg,false)){
    var ui:VDB = DataBindingUtil.bind(itemView)!!

    abstract fun bindData(data: Any)
}