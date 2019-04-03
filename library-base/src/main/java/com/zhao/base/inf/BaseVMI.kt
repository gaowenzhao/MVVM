package com.zhao.base.inf

import io.reactivex.observers.DisposableObserver

interface BaseVMI {
    fun unsubcrible()
    fun addSubscription(s: DisposableObserver<*>)
}