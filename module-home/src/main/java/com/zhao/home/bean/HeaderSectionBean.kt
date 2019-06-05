package com.zhao.home.bean

import androidx.databinding.BaseObservable


/**
 * gaowenzhao
 */
class HeaderSectionBean(var img:String,var firstTitle:String,var secondTitle:String):BaseObservable(){
    var findAll:String? = null
    var marketUrl:String? = null
//    val h5Url by lazy {
//        host.url+"/"+marketUrl
//    }
}