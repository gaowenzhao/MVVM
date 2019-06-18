package com.zhao.base.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseViewHolder<VDB : ViewDataBinding,T: Any>(layoutId: Int, vg:ViewGroup): RecyclerView.ViewHolder(LayoutInflater.from(vg.context).inflate(layoutId,vg,false)){
    var ui:VDB = DataBindingUtil.bind(itemView)!!
    lateinit var mData: T
    open fun initData(data: Any){
        mData = data as T
        bindData()
    }
    open fun bindData(){
    }
}