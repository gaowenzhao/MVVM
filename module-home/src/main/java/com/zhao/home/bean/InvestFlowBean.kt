package com.zhao.home.bean

import android.databinding.BaseObservable


class InvestFlowBean : BaseObservable(){
    lateinit var firstTitle:String
    lateinit var secondTitle:String
    lateinit var image:String
    lateinit var buttons:List<ButtonBean>
}