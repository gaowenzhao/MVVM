package com.zhao.home.bean

import androidx.databinding.BaseObservable
import com.zhao.base.http.CommonUrl

class EntranceBean :BaseObservable(){
    var isDone:Boolean = false
    var no:Int = 0
    var description:String?=null
    lateinit var name:String
     var image:String = ""
    var activeImage:String?=null
    lateinit var url:String
    val imageUrl by lazy { if (image.startsWith("http")) image else CommonUrl.URL+image }

}