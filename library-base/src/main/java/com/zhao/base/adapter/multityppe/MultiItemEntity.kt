package com.zhao.base.adapter.multityppe

import com.hzcfapp.qmwallet.widget.recycler.MultiEntityBuilder
import com.hzcfapp.qmwallet.widget.recycler.MultipleFields

class MultiItemEntity(var map:HashMap<Any,Any>) {
    companion object {
        fun builder(): MultiEntityBuilder {
            return MultiEntityBuilder()
        }
    }
    fun getItemType(): Int {
        return map[MultipleFields.VH_TYPE] as Int
    }
    fun getSpanSize():Int{
        return map[MultipleFields.SPAN_SIZE] as Int
    }
    fun <T> getValue(key:Any):T {
        return map[key] as T
    }
    fun <T> getData():T {
        return map[MultipleFields.CONTENT] as T
    }
}