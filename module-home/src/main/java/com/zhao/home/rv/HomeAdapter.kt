package com.zhao.home.rv

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.zhao.base.adapter.BaseMultiItemAdapter

class HomeAdapter : BaseMultiItemAdapter() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    /* override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
         return when (viewType) {
             VHType.BANNER.code -> {
                 BannerVH(parent)
             }
             else -> {
                 AdverVH(parent)
             }
         }
     }*/
}