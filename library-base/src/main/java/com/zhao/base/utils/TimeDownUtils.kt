package com.hzcf.model.base.tools

import android.widget.TextView
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.concurrent.TimeUnit

object TimeDownUtils {
  private var mSubscription: Subscription? = null // Subscription 对象，用于取消订阅关系，防止内存泄露
  fun start(textView: TextView) {
    val count = 59L
    Flowable.interval(0, 1, TimeUnit.SECONDS)//设置0延迟，每隔一秒发送一条数据
      .onBackpressureBuffer()//加上背压策略
      .take(count) //设置循环次数
      .map { aLong ->
        count - aLong //
      }
      .observeOn(AndroidSchedulers.mainThread())//操作UI主要在UI线程
      .subscribe(object : Subscriber<Long> {
        override fun onSubscribe(s: Subscription?) {
          textView.isEnabled = false
          mSubscription = s
          s?.request(Long.MAX_VALUE)//设置请求事件的数量，重要，必须调用
        }

        override fun onNext(aLong: Long?) {
          //接受到一条就是会操作一次UI
          textView.text = "${aLong}s后重新获取"
        }

        override fun onComplete() {
          textView.text = "点击获取验证码"
          textView.isEnabled = true
          cancelTimer()
        }

        override fun onError(t: Throwable?) {
          t?.printStackTrace()
        }
      })
  }

  fun cancelTimer() {
    mSubscription?.cancel()//取消订阅，防止内存泄漏
    mSubscription = null
  }

   fun isRunning(): Boolean {
    return mSubscription != null
  }
}