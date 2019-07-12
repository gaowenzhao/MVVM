package com.zhao.base.app

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.zhao.base.BuildConfig


open class BaseApplication :Application(){
    companion object {
        @JvmStatic
        lateinit var appContext: Context
        lateinit var instance:BaseApplication
    }
    override fun onCreate() {
        super.onCreate()
        appContext = this
        instance = this
        initARouter()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
    private fun initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
 }