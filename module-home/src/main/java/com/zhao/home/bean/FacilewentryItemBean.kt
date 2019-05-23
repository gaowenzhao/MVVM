package com.zhao.home.bean

import android.databinding.BaseObservable

class FacilewentryItemBean:BaseObservable() {
    var activeColor:String? = null
    var activeImage:String? = null
    var defaultColor:String? = null
    var description:String? = null
    var done:Boolean = false
    lateinit var image:String
    lateinit var name:String
    var no:Int = 0
    var time:Long = 0
    var type:String? = null
    lateinit var url:String
    var native_url:String? = null
//    val h5Url by lazy {
//        Hoster.host.url + url
//    }
   var hasPay = false
}