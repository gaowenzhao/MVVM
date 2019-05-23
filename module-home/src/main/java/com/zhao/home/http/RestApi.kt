package com.zhao.base.http

import com.hzcf.model.home.bean.AfficheBean
import com.hzcf.model.home.bean.BeanGetHomePopupInformation
import com.hzcf.model.home.bean.BidBean
import com.hzcf.model.home.bean.HomeDataBean
import com.zhao.base.http.bean.BaseBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RestApi {
    /**
     * 首页轮播图
     */
    @GET("/hzed-qmwallet-app/advertisement/bannerList")
    fun getBannerList(): Observable<BaseBean<Any>>

    /**
     * 获取首页
     */
    @GET("/refactoring/investment/common/homeInfo")
    fun getHomeInfo(@QueryMap map: Map<String, String>): Observable<BaseBean<HomeDataBean>>

    /**
     * 获取公告
     */
    @GET("/refactoring/investment/h5/affiche")
    fun getAffiche(@QueryMap map: Map<String, String>): Observable<BaseBean<AfficheBean>>

    /**
     * 获取标
     */
    @GET("/refactoring/investment/common/bidList")
    fun getbidList(@QueryMap map: Map<String, String>): Observable<BaseBean<List<BidBean>>>

    /**
     * 获取首页底部文案
     */
    @GET("/refactoring/investment/app/common/text")
    fun getBottomText(@QueryMap map: Map<String, String>): Observable<BaseBean<String>>

    @GET("/refactoring/investment/common/getHomePopupInformation")//首页弹窗
    fun getHomePopupInformation(): Observable<BaseBean<BeanGetHomePopupInformation>>
}