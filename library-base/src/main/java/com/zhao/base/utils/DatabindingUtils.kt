package com.zhao.base.utils

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.zhao.base.app.BaseApplication

object DatabindingUtils {
    @JvmStatic
    @BindingAdapter("app:res")
    fun setSrc(view: ImageView, resId: Int) {
        view.setImageResource(resId)
    }
    @JvmStatic
    @BindingAdapter("app:url")
    fun setSrc(view: ImageView, url:String) {
        Glide.with(BaseApplication.appContext)
            .load(url)
            .into(view)
    }
    @BindingAdapter("app:imageUrl", "app:placeHolder", "app:error")
    @JvmStatic
    fun setSrc(v: ImageView, url: String?, holderDrawable: Int,errorDrawable:Int) {
        Glide.with(v.context)
            .load(url)
            .placeholder(holderDrawable)
            .error(errorDrawable)
            .into(v)
    }
}