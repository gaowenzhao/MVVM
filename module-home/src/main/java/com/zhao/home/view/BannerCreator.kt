package com.zhao.home.view

import com.ToxicBakery.viewpager.transforms.DefaultTransformer
import com.bigkoo.convenientbanner.ConvenientBanner
import com.bigkoo.convenientbanner.listener.OnItemClickListener
import com.zhao.home.bean.BannerBean

class BannerCreator {
    companion object {
        fun setDefault(convenientBanner: ConvenientBanner<BannerBean>, banners: List<BannerBean>, clickListener: OnItemClickListener) {
                convenientBanner
                        .setPages(HolderCreator(), banners)
                        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                        .setOnItemClickListener(clickListener)
                        .setPageTransformer(DefaultTransformer())
        }

    }

}