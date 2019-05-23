package com.zhao.home.vm.rv

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.zhao.home.BR
import com.zhao.home.R

class BannerBean : BaseObservable() {
    internal var banner = "banner"
    var white = false
    var img = R.mipmap.ic_launcher

    @Bindable
    fun getBanner(): String {
        return banner
    }

    fun setBanner(banner: String) {
        this.banner = banner
        notifyPropertyChanged(BR.banner)
    }

}
