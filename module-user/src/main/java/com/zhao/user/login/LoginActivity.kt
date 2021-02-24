package com.zhao.user.login

import android.widget.Toast
import androidx.lifecycle.observe
import com.alibaba.android.arouter.facade.annotation.Route
import com.charles.livedatabus.LiveDataBus
import com.zhao.base.inf.BaseSimpleActivity
import com.zhao.base.utils.router.RouterUrl
import com.zhao.user.R
import com.zhao.user.databinding.ActivityLoginBinding
@Route(path = RouterUrl.User.LoginActivity)
class LoginActivity: BaseSimpleActivity<ActivityLoginBinding>() {
    override var fitsSystemWindows: Boolean = true
    override var layoutId: Int = R.layout.activity_login

    override fun initView() {
        ui.textViewClick.setOnClickListener {
            LiveDataBus.get().with("test").value="登陆返回"
        }
    }
    override fun initData() {
        LiveDataBus.get().with("test").observe(this) {
            Toast.makeText(this,it.toString(),Toast.LENGTH_LONG).show()
        }
    }
}