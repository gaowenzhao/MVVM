package com.zhao.home.rv

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.zhao.base.adapter.BaseAdapter
import com.zhao.home.rv.vh.BannerVH
import com.zhao.home.vm.rv.BannerVM


class SimpleAdapter(var datas:ArrayList<BannerVM>) :BaseAdapter(datas){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return BannerVH(p0)
    }
}