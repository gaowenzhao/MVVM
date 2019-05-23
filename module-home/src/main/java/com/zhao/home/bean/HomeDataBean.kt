package com.zhao.home.bean

import android.databinding.BaseObservable


class HomeDataBean :BaseObservable(){
    var isLogin: Boolean = false
    var isFirstInvestment: Boolean = false
    var zongcoinmarket: MarketBean? = null //粽币商城
    var platformadvertisings: PlatformadBean? = null//平台实力
    lateinit var banners: List<BannerBean> //广告位
    var advertisings: List<BannerBean>? = null//广告
    var normalEntrance: List<EntranceBean>? = null //信息披露,合众数据...
    var investmentFlow: InvestFlowBean? = null //投资流程
    var facilewentry: FacilewentryBean? = null

}