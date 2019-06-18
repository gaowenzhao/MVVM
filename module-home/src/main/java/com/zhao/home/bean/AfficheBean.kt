package com.zhao.home.bean

import android.databinding.BaseObservable


/**
 * 公告
 */
class AfficheBean : BaseObservable(){
     var id : Int = 0
     lateinit var description: String
     var image: String? = null
     lateinit var url: String
}