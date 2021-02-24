package com.charles.livedatabus

import androidx.lifecycle.MutableLiveData

class LiveDataBus {
    var data = HashMap<String,MyLiveData<Any>>()
    companion object {
        private var instance: LiveDataBus? = null
            get() {
                if (field == null) {
                    field = LiveDataBus()
                }
                return field
            }
        fun get(): LiveDataBus{
            return instance!!
        }
    }
    fun with(key:String): MutableLiveData<Any> {
        if(!data.containsKey(key)){
            data[key] = MyLiveData()
        }
        return data[key]!!
    }
}