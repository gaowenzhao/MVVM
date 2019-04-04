package com.zhao.base.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.zhao.base.inf.BaseVM

abstract class BaseAdapter(private var datas:List<BaseVM>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(vh: RecyclerView.ViewHolder, position: Int) {
        (vh as BaseViewHolder<ViewDataBinding>).bindData(datas[position])
    }
}