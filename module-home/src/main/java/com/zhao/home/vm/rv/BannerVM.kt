package com.zhao.home.vm.rv

import android.arch.lifecycle.MutableLiveData
import com.zhao.base.inf.BaseVM

class BannerVM :BaseVM(){
    var banner = MutableLiveData<String>().also { it.value="banner" }

}