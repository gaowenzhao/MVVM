package com.zhao.user

import android.util.Log
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.zhao.base.inf.BaseVMFragment
import com.zhao.base.inf.BaseVM
import com.zhao.base.utils.router.RouterUrl
import com.zhao.user.databinding.FragmentUserBinding

@Route(path = RouterUrl.User.TabUser)
class UserVMFragment : BaseVMFragment<FragmentUserBinding, BaseVM>(){
    override var darkMode: Boolean = true
    override var layoutId: Int = R.layout.fragment_user
    override fun initData() {
    }

    override fun initView(RootView: View) {
    }
    override fun onUserVisible() {
        Log.i("UserVMFragment","UserVMFragment::onUserVisible")
    }
}