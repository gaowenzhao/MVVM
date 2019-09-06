package com.zhao.home.rv.vh

import android.view.ViewGroup
import com.zhao.base.adapter.BaseViewHolder
import com.zhao.home.R
import com.zhao.home.bean.EntranceBean
import com.zhao.home.databinding.HomeItemEntranceBinding

class NormalEntranceVH(vg: ViewGroup) :BaseViewHolder<HomeItemEntranceBinding,EntranceBean>(R.layout.home_item_entrance,vg){
    override fun bindData() {
        ui.bean = mData
    }
}