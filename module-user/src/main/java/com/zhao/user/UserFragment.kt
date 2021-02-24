package com.zhao.user

import android.util.Log
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.zhao.base.inf.BaseFragment
import com.zhao.base.inf.BaseVM
import com.zhao.base.utils.router.RouterUrl
import com.zhao.user.databinding.FragmentUserBinding

class UserFragment : BaseFragment<FragmentUserBinding, BaseVM>(){
    override var darkMode: Boolean = true
    override var fitsSystemWindows: Boolean = true
    override var layoutId: Int = R.layout.fragment_user
    override fun initData() {
    }

    override fun initView(RootView: View) {
    }
    override fun onUserVisible() {
        Log.i("UserFragment","UserFragment::onUserVisible")
    }
}