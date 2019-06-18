package com.zhao.home.rv.vh
import android.support.v4.view.ViewPager
import android.view.ViewGroup
import com.bigkoo.convenientbanner.ConvenientBanner
import com.zhao.base.adapter.BaseViewHolder
import com.zhao.home.R
import com.zhao.home.bean.BannerBean
import com.zhao.home.databinding.HomeItemBannerBinding
import com.zhao.home.view.BannerCreator

class BannerVH(vg: ViewGroup): BaseViewHolder<HomeItemBannerBinding, List<BannerBean>>(R.layout.home_item_banner,vg){
    override fun bindData() {
        BannerCreator.setDefault(ui.convenientBanner as ConvenientBanner<BannerBean>, mData, com.bigkoo.convenientbanner.listener.OnItemClickListener {})
        ui.tvNo?.text = "1/${mData.size}"
        ui.convenientBanner.onPageChangeListener = object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {}
            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {}
            override fun onPageSelected(p0: Int) {
                ui.tvNo?.text = "${p0 + 1}/${mData.size}"
            }
        }
        if (mData.size > 1 && !ui.convenientBanner.isTurning) {
            ui.convenientBanner.startTurning(5000)
        }
    }
}