package com.zhao.home.rv.vh
import android.view.ViewGroup
import com.zhao.base.adapter.BaseViewHolder
import com.zhao.base.inf.BaseVM
import com.zhao.home.R
import com.zhao.home.databinding.HomeItemAdverBinding
import com.zhao.home.vm.rv.AdverVM

class AdverVH(vg: ViewGroup) :BaseViewHolder<HomeItemAdverBinding>(R.layout.home_item_adver,vg){
    override fun bindData(vm: BaseVM) {
        ui.vm = vm as AdverVM
    }
}