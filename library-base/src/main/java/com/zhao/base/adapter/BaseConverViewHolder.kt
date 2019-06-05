package com.zhao.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseConverViewHolder<VDB : ViewDataBinding,T>(layoutId: Int, vg:ViewGroup): androidx.recyclerview.widget.RecyclerView.ViewHolder(LayoutInflater.from(vg.context).inflate(layoutId,vg,false)){
    var ui:VDB = DataBindingUtil.bind(itemView)!!

    abstract fun bindData(data: Any)
}