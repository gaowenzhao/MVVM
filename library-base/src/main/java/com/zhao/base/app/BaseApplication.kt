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
        // 安装tinker
        Beta.installTinker()
    }
    private fun initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
    private fun initBugly(){
        WalleChannelReader.getChannel(getApplication())?.let {
            Bugly.setAppChannel(getApplication(), it)
        }
        Bugly.setIsDevelopmentDevice(this,true)//设置为开发设备
        // 这里实现SDK初始化，appId替换成你的在Bugly平台申请的appId
        Bugly.init(this, "e79d203d8a", BuildConfig.DEBUG) //合众的
    }
 }