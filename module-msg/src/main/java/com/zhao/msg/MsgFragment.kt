package com.zhao.msg

import android.util.Log
import android.view.View
import androidx.lifecycle.observe
import com.alibaba.android.arouter.launcher.ARouter
import com.charles.livedatabus.LiveDataBus
import com.zhao.base.inf.BaseFragment
import com.zhao.base.inf.BaseVM
import com.zhao.base.utils.router.RouterUrl
import com.zhao.msg.databinding.FragmentMsgBinding

class MsgFragment : BaseFragment<FragmentMsgBinding, BaseVM>(){
    override var darkMode: Boolean = true
    override var fitsSystemWindows: Boolean = true
    override var layoutId: Int = R.layout.fragment_msg
    override fun initData() {
        LiveDataBus.get().with("test").observe(this) {
            ui.textViewClick.text = it.toString()
        }
    }

    override fun initView(RootView: View) {
      ui.textViewClick.setOnClickListener {
          LiveDataBus.get().with("test").value = "test"
          ARouter.getInstance().build(RouterUrl.User.LoginActivity).navigation()
      }
    }
    override fun onUserVisible() {
        Log.i("MsgFragment","MsgFragment::onUserVisible")
    }
}