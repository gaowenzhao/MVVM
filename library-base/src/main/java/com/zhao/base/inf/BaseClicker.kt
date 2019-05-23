package com.zhao.base.inf

import android.view.View
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

interface BaseClicker : View.OnClickListener, View.OnLongClickListener {

    override fun onLongClick(v: View?): Boolean {
        return true
    }

    //==============================================
    fun addCooler(v: View, msec: Long = 1000) {
        val obs = object : Observer<Any> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Any) {
                onClick(v)
            }

            override fun onComplete() {
            }

            override fun onError(e: Throwable) {
            }
        }
        RxView.clicks(v).throttleFirst(msec, TimeUnit.MILLISECONDS).subscribe(obs)
    }
}