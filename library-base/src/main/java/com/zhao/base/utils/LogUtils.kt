package com.zhao.base.utils

import android.os.Build
import android.util.Log
import com.zhao.base.BuildConfig

/**
 * 输出系统日志
 *
 * @author rg65544
 * @date 2018/5/31
 */
object LogUtils {
    /**
     * 是否需要打印bug，可以在application的onCreate函数里面初始化
     */
    private val isDebug = BuildConfig.DEBUG
    private const val TAG = "HAO_YI_JIE"

    /**
     * 下面是传入自定义tag的函数
     */
    fun i(tag: String = TAG, msg: String) {
        if (isDebug) {
            Log.i(tag, msg)
        }
    }

    fun d(tag: String = TAG, msg: String) {
        if (isDebug) {
            Log.i(tag, msg)
        }
    }

    fun e(tag: String = TAG, msg: String) {
        if (isDebug) {
            Log.i(tag, msg)
        }
    }

    fun v(tag: String = TAG, msg: String) {
        if (isDebug) {
            Log.i(tag, msg)
        }
    }
}
