package com.zhao.base.utils

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zhao.base.app.BaseApplication

object DatabindingUtils {
    private val options by lazy { RequestOptions() }
    @JvmStatic
    @BindingAdapter("app:src")
    fun setSrc(view: ImageView, resId: Int) {
        view.setImageResource(resId)
    }
    @JvmStatic
    @BindingAdapter("app:url")
    fun setSrc(view: ImageView, url:String) {
        Glide.with(BaseApplication.appContext)
            .load(url)
            .apply(options)
            .into(view)
    }
}