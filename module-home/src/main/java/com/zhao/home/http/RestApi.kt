package com.zhao.home.http

import com.zhao.base.http.bean.BaseBean
import com.zhao.home.bean.AfficheBean
import com.zhao.home.bean.BeanGetHomePopupInformation
import com.zhao.home.bean.BidBean
import com.zhao.home.bean.HomeDataBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
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
    fun getHomeInfo(@QueryMap map: Map<String, String>): Observable<BaseBean<HomeDataBean>>//HomeDataBean

    /**
     * 获取公告
     */
    @GET("/refactoring/investment/h5/affiche")
    fun getAffiche(@QueryMap map: Map<String, String>): Observable<BaseBean<AfficheBean>>//AfficheBean

    /**
     * 获取标
     */
    @GET("/refactoring/investment/common/bidList")
    fun getbidList(@QueryMap map: Map<String, String>): Observable<BaseBean<ArrayList<BidBean>>>

    /**
     * 获取首页底部文案
     */
    @Headers("Domain-Name: https")
    @GET("/refactoring/investment/app/common/text")
    fun getBottomText(@QueryMap map: Map<String, String>): Observable<BaseBean<String>>

    @GET("/refactoring/investment/common/getHomePopupInformation")//首页弹窗
    fun getHomePopupInformation(): Observable<BaseBean<BeanGetHomePopupInformation>>


}