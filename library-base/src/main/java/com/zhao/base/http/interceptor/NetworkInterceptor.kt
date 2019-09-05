package com.zhao.base.http.interceptor

import com.zhao.base.http.Httper
import com.zhao.base.utils.HeaderUtils
import okhttp3.Interceptor
import okhttp3.Response

//请求头的添加
class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val cacheControl = request.cacheControl().toString()
        val updateRequest = request.newBuilder()
            .header("Cache-Control", cacheControl)
            .header("Content-Type", "application/json; charset=UTF-8")
//         .header("imei", HeaderUtils.getIMEI())//需要动态申请权限
            .header("client", HeaderUtils.getPlatform())
            .header("version", HeaderUtils.getVersionName())
            .header("id", Httper.token)
            .header("token", Httper.token)
            .build()
        return chain.proceed(updateRequest)
    }

}