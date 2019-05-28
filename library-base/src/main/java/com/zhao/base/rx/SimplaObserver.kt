package com.zhao.base.rx

import io.reactivex.observers.DisposableObserver

open class SimplaObserver<T> :DisposableObserver<T>(){
     override fun onComplete() {
     }

     override fun onNext(t: T) {
     }

     override fun onError(e: Throwable) {
     }
 }