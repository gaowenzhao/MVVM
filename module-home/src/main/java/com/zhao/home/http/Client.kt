package com.zhao.base.http

object Client {
    val api: RestApi by lazy { Httper.createApi(RestApi::class.java) }
}