package com.zhao.home

import com.alibaba.android.arouter.facade.annotation.Route
import com.zhao.base.inf.BaseVMFragment
import com.zhao.base.utils.router.RouterUrl
import com.zhao.home.databinding.FragmentHomeBinding
import com.zhao.home.vm.HomeVM


@Route(path = RouterUrl.Home.TabHome)
class HomeFragment : BaseVMFragment<FragmentHomeBinding, HomeVM>(){
     override var darkMode: Boolean = false
     override var fitsSystemWindows: Boolean = true
     override var layoutId: Int = R.layout.fragment_home
     override var statusBarColor: Int = R.color.colorPrimary
     override fun initUIVM() {
         ui.vm = vm
     }
     override fun initData() {
          vm.initData()
     }
}