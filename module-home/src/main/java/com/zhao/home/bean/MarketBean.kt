package com.zhao.home.bean

import androidx.databinding.BaseObservable


/**
 * gaowenzhao
 */
class MarketBean : BaseObservable(){
    lateinit var firstTitle:String
    lateinit var secondTitle:String
    lateinit var buttons:List<ButtonBean>
    lateinit var image:String
    var findAll:String? = null
    var marketUrl:String? = null
}