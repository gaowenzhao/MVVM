package com.zhao.home.bean

import android.databinding.BaseObservable

class BannerBean : BaseObservable(){
    var id:Int = 0
    var no:Int = 0
    var description:String?=null
    lateinit var image:String
    var isFestivalVersion:Boolean = false
    var url: String? = null
    var defaultImgRes = -1
}