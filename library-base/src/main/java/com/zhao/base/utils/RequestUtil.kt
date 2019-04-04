package com.zhao.base.utils

object RequestUtil {
    const val DEFAULT = 0
    const val ERROR = 1
    const val SUCCESS = 2
    var key = 0
    private val requestFields: HashMap<Any, Int> = HashMap()
    fun setCallBackStatus(status:Int){
        key++
        requestFields[key] = status
    }
}