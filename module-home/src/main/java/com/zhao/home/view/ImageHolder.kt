package com.zhao.home.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.bigkoo.convenientbanner.holder.Holder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.zhao.base.http.CommonUrl
import com.zhao.home.R
import com.zhao.home.bean.BannerBean

class ImageHolder : Holder<BannerBean> {
    private lateinit var mImageView: ImageView
    companion object {
        private val BANNER_OPTIONS = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .dontAnimate()
    }

    override fun UpdateUI(context: Context?, position: Int, data: BannerBean) {
        if (context != null) {
            BANNER_OPTIONS.placeholder(data.defaultImgRes)
            Glide.with(context)
                .load(CommonUrl.URL+data.image)
                .apply(BANNER_OPTIONS)
                .into(mImageView)
        }
    }

    override fun createView(context: Context?): View {
        var contentView = LayoutInflater.from(context).inflate(R.layout.home_item_banner_image,null)
        mImageView = contentView.findViewById(R.id.iv_banner)
        return contentView
    }
}