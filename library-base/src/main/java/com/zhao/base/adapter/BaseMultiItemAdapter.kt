package com.zhao.base.adapter

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableArrayList
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zhao.base.adapter.multityppe.MultiItemEntity

abstract class BaseMultiItemAdapter(val datas: ObservableArrayList<MultiItemEntity>) : ObservableAdapter<MultiItemEntity>(datas),MutableList<MultiItemEntity> by datas{
     override fun onBindViewHolder(vh: RecyclerView.ViewHolder, position: Int) {
         (vh as BaseViewHolder<ViewDataBinding, BaseObservable>).initData(datas[position].getData() as Any)
     }
     override fun getItemCount(): Int {
        return  datas.size
    }
    override fun getItemViewType(position: Int): Int {
        return datas[position].getItemType()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        val manager = recyclerView.layoutManager
        if (manager is GridLayoutManager) {
            manager.spanSizeLookup = object: GridLayoutManager.SpanSizeLookup(){
                override fun getSpanSize(p0: Int): Int {
                    return datas[p0].getSpanSize()
                }
            }
        }
    }
   open fun update(list:ObservableArrayList<MultiItemEntity>){
       datas.clear()
       datas.addAll(list)
    }
}