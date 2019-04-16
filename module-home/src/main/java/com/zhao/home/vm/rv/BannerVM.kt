package com.zhao.home.vm.rv

import com.zhao.base.inf.BaseVM
import com.zhao.home.R

class BannerVM :BaseVM(){
    var banner = "banner"
    var white = false
    val img by lazy { if(white) R.mipmap.ic_launcher else R.mipmap.ic_back}
}