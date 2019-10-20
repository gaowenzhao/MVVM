package com.zhao.user.login

import com.alibaba.android.arouter.facade.annotation.Route
import com.zhao.base.inf.BaseSimpleActivity
import com.zhao.base.utils.router.RouterUrl
import com.zhao.user.R
import com.zhao.user.databinding.ActivityLoginBinding
@Route(path = RouterUrl.User.LoginActivity)
class LoginActivity: BaseSimpleActivity<ActivityLoginBinding>() {
    override var fitsSystemWindows: Boolean = true
    override var layoutId: Int = R.layout.activity_login

    override fun initView() {
    }

    override fun initData() {
    }
}