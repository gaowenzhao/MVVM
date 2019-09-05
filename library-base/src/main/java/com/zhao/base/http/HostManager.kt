package com.zhao.base.http

object HostManager {
    private val hostMap = HashMap<String,String>()
    init {
        hostMap["http"] = "http://wwww.hzed.com"
        hostMap["https"] = "https://m.hzed.com"
    }
    fun putHost(key:String,value:String){
         hostMap[key] = value
    }
    fun getHost(key:String): String? {
        return  hostMap[key]
    }
}