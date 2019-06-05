package com.zhao.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseViewHolder<VDB : ViewDataBinding,T: Any>(layoutId: Int, vg:ViewGroup): androidx.recyclerview.widget.RecyclerView.ViewHolder(LayoutInflater.from(vg.context).inflate(layoutId,vg,false)){
    var ui:VDB = DataBindingUtil.bind(itemView)!!
    lateinit var mData: T
    open fun initData(data: Any){
        mData = data as T
        bindData()
    }
    open fun bindData(){
    }
}