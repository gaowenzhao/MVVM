package com.zhao.base.adapter.multityppe

import com.hzcfapp.qmwallet.widget.recycler.MultiEntityBuilder

interface MultiEntityBuilderI {
    fun setSpanSize(value:Int): MultiEntityBuilder
    fun setVhType(value:Int): MultiEntityBuilder
    fun setContent(value:Any): MultiEntityBuilder
}