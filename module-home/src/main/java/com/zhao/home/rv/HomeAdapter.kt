package com.zhao.home.rv

import android.databinding.ObservableArrayList
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.hzcfapp.qmwallet.widget.recycler.VHType
import com.zhao.base.adapter.BaseMultiItemAdapter
import com.zhao.base.adapter.multityppe.MultiItemEntity
import com.zhao.home.rv.vh.AdverVH
import com.zhao.home.rv.vh.BannerVH
import com.zhao.home.rv.vh.BidVH
import com.zhao.home.rv.vh.NormalEntranceVH
class HomeAdapter(datas: ObservableArrayList<MultiItemEntity>) : BaseMultiItemAdapter(datas) {
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
         return when (viewType) {
             VHType.BANNER.code -> {
                 BannerVH(parent)
             }
             VHType.ADVER.code->{
                 AdverVH(parent)
             }
             VHType.NORMALENTRANCE.code -> {
                 NormalEntranceVH(parent)
             }else->{
                 BidVH(parent)
             }

         }
     }
}