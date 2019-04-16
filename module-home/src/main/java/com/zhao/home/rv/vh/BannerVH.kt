package com.zhao.home.rv.vh
import android.view.ViewGroup
import com.zhao.base.adapter.BaseViewHolder
import com.zhao.base.inf.BaseVM
import com.zhao.home.R
import com.zhao.home.databinding.HomeBannerBinding
import com.zhao.home.vm.rv.BannerVM

class BannerVH(vg: ViewGroup) :BaseViewHolder<HomeBannerBinding>(R.layout.home_item_banner,vg){
    override fun bindData(vm: BaseVM) {
        ui.vm = vm as BannerVM
    }
}