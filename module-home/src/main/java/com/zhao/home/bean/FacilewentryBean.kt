package com.zhao.home.bean

import android.databinding.BaseObservable


class FacilewentryBean: BaseObservable() {
    lateinit var firstTitle:String
    lateinit var secondTitle:String
    lateinit var image:String
    lateinit var facilewentry:List<FacilewentryItemBean>
}