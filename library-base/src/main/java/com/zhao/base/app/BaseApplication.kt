package com.zhao.base.app

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.tencent.bugly.Bugly
import com.tencent.bugly.beta.Beta
import com.zhao.base.BuildConfig
import com.tencent.bugly.beta.tinker.TinkerManager.getApplication
import com.meituan.android.walle.WalleChannelReader



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
        initBugly()
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
    private fun initBugly(){
        val channel = WalleChannelReader.getChannel(getApplication())
        Bugly.setAppChannel(getApplication(), channel)
        // 这里实现SDK初始化，appId替换成你的在Bugly平台申请的appId
        Bugly.init(this, "0e64a4721e", BuildConfig.DEBUG) //合众的
    }
 }