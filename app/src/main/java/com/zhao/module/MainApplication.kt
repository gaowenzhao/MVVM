package com.zhao.module

import android.content.Context
import android.util.Log
import com.tinkerpatch.sdk.TinkerPatch
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike
import com.zhao.base.app.BaseApplication

class MainApplication : BaseApplication() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Log.i("MainApplication","time=${System.currentTimeMillis()}")
    }

    override fun onCreate() {
        super.onCreate()
        iniTinkerPath()
    }
    private fun iniTinkerPath(){
        // 我们可以从这里获得Tinker加载过程的信息
        val tinkerApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike()
        // 初始化TinkerPatch SDK, 更多配置可参照API章节中的,初始化SDK
        TinkerPatch.init(tinkerApplicationLike)
            .reflectPatchLibrary()
            .setPatchRollbackOnScreenOff(true)
            .setPatchRestartOnSrceenOff(true)
            .setFetchPatchIntervalByHours(3)
        // 每隔3个小时(通过setFetchPatchIntervalByHours设置)去访问后台时候有更新,通过handler实现轮训的效果
        TinkerPatch.with().fetchPatchUpdateAndPollWithInterval()
    }
}