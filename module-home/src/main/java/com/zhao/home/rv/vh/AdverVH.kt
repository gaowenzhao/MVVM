package com.zhao.home.rv.vh
import android.view.ViewGroup
import com.bigkoo.convenientbanner.ConvenientBanner
import com.hzcfapp.qmwallet.widget.recycler.MultipleFields
import com.zhao.base.adapter.BaseViewHolder
import com.zhao.home.R
import com.zhao.home.bean.BannerBean
import com.zhao.home.databinding.HomeItemAdverBinding
import com.zhao.home.view.BannerCreator
import com.zhao.home.vm.rv.AdverBean

class AdverVH(vg: ViewGroup) : BaseViewHolder<HomeItemAdverBinding, List<BannerBean>>(R.layout.home_item_adver,vg){
    override fun bindData() {
        BannerCreator.setDefault(ui.banner as ConvenientBanner<BannerBean>, mData, com.bigkoo.convenientbanner.listener.OnItemClickListener {
        })
        if (mData.size > 1 && !ui.banner.isTurning) {
            ui.banner.startTurning(5000)
        }
    }
}