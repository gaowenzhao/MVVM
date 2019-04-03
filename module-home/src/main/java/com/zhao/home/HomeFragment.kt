package com.zhao.home

import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.zhao.base.inf.BaseFragment
import com.zhao.base.utils.router.RouterUrl
import com.zhao.home.databinding.FragmentHomeBinding
import com.zhao.home.rv.HomeAdapter
import com.zhao.home.vm.HomeVM


@Route(path = RouterUrl.Home.TabHome)
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>(){
     override var darkMode: Boolean = false
     override var fitsSystemWindows: Boolean = true
     override var layoutId: Int = R.layout.fragment_home
     override var statusBarColor: Int = R.color.colorPrimary
     private lateinit var homeAdapter:HomeAdapter
     override fun initUIVM() {
         ui.vm = vm
     }

     override fun initView(RootView: View) {
          var manager = GridLayoutManager(context, 2)
          ui.rvData.layoutManager = manager
     }
     override fun initData() {
          homeAdapter = HomeAdapter(vm.initData())
          ui.rvData.adapter = homeAdapter
     }
}