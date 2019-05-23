package com.zhao.home.bean

import android.databinding.BaseObservable

class EntranceBean :BaseObservable(){
    var isDone:Boolean = false
    var no:Int = 0
    var description:String?=null
    lateinit var name:String
    lateinit var image:String
    var activeImage:String?=null
    lateinit var url:String
}