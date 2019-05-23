package com.zhao.home.bean

import android.databinding.BaseObservable


class ButtonBean:BaseObservable() {
    var isDone:Boolean = false
    var no:Int = 1
    var description:String?=null
    var name:String?=null
    lateinit var image:String
    var activeImage:String?=null
    lateinit var url:String
    var native_url:String?=null
    var time:String?=null
//    val h5Url by lazy {
//        if(url.startsWith("http")){
//              url
//        }else{
//            Hoster.host.url+url
//        }
//    }
}