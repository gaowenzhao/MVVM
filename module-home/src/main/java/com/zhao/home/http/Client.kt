package com.zhao.home.http

import com.zhao.base.http.Httper

object Client {
    val api: RestApi by lazy { Httper.createApi(RestApi::class.java) }
}