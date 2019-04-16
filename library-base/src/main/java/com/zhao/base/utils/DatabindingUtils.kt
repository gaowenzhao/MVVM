package com.zhao.base.utils

import android.databinding.BindingAdapter
import android.widget.ImageView

object DatabindingUtils {
    @JvmStatic
    @BindingAdapter("app:src")
    fun setSrc(view: ImageView, resId: Int) {
        view.setImageResource(resId)
    }

}