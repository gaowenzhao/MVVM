package com.zhao.base.http.interceptor

import com.zhao.base.http.HostManager
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

//对baseUrl的替换
class HttpInterceptor : Interceptor {
    companion object {
        const val Tag = "HttpInterceptor"
        const val DomainName = "Domain-Name"
    }
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url()
        val headers = request.headers(DomainName)
        val newBuilder = request.newBuilder()
        if (headers.size > 0) {
            if ("https" == headers[0]) {
                newBuilder.url(parseUrl(HostManager.getHost("https")!!,url))
            }
            newBuilder.removeHeader(DomainName)
        }
        return chain.proceed(newBuilder.build())
    }

   private fun parseUrl(newHost:String,oldUrl:HttpUrl):HttpUrl{//https://
        val newHttpUrl = HttpUrl.get(newHost)
        return oldUrl.newBuilder()
            .scheme(newHttpUrl.scheme())
            .host(newHttpUrl.host())
            .build()
    }
}