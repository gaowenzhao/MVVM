package com.zhao.module

import android.content.Intent
import android.os.Handler
import com.zhao.base.inf.BaseSimpleActivity
import com.zhao.module.databinding.SplashActivityBinding

class SplashActivity: BaseSimpleActivity<SplashActivityBinding>() {
    override var layoutId: Int = R.layout.splash_activity
    private val mHandler = Handler()
    override fun initView() {
        mHandler.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },1500)
    }

    override fun initData() {
    }
}