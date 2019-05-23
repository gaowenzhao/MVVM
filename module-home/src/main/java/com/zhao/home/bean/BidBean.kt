package com.zhao.home.bean

import android.databinding.BaseObservable


class BidBean:BaseObservable() {
    lateinit var apr: String         //年利率
    var extraApr: String? = null      //补充年利率
    lateinit var tag: String       //"新手专享/限投1次",
    lateinit var period: String
    var url: String? = ""
    var productId: Int = 0        //计划类型。8：智盈存 9：E计划(包括车贷E计划和消费贷E计划)
    var productType: Int = 0      //产品类型，1：新手 2：普通
    var planBidType: Int = 0      //优选计划标识：为了配合APP，这里多加一个标识
    var id: Long = 0
    var title: String? = null         //借款标题
    var listTitle: String? = null  //[标题信息]
    lateinit var name: String      //"新手专享标（30天）",
    var loanSchedule: String? = null      //借款进度比例 如：100-已满标；小于100-未满标
    var bottomText: String? = null //"资金存管由白名单银行提供服务",
    lateinit var aprText: String    //"约定年化利率",
    var buttonText: String?=null //"新手出借",
    var periodUnit: Int = 0          //理财计划标期限类型 -1-年; 0-月; 1-天;
}