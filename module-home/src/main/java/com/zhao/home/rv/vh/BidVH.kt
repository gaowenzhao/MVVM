package com.zhao.home.rv.vh

import android.view.ViewGroup
import com.zhao.base.adapter.BaseViewHolder
import com.zhao.home.R
import com.zhao.home.bean.BidBean
import com.zhao.home.databinding.HomeItemBidBinding


class BidVH(vg: ViewGroup) : BaseViewHolder<HomeItemBidBinding,BidBean>(R.layout.home_item_bid,vg){
    override fun bindData() {
         ui.bean = mData
    }
}
