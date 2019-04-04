package com.zhao.home

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.zhao.base.inf.BaseFragment
import com.zhao.base.utils.router.RouterUrl
import com.zhao.home.databinding.FragmentHomeBinding
import com.zhao.home.rv.SimpleAdapter
import com.zhao.home.vm.HomeVM


@Route(path = RouterUrl.Home.TabHome)
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>(){
     override var darkMode: Boolean = false
     override var fitsSystemWindows: Boolean = true
     override var layoutId: Int = R.layout.fragment_home
     override var statusBarColor: Int = R.color.colorPrimary
     private lateinit var homeAdapter:SimpleAdapter
     override fun initUIVM() {
         ui.vm = vm
     }

     override fun initView(RootView: View) {
          var manager = LinearLayoutManager(context)
          ui.rvData.layoutManager = manager
          ui.tvTitle.setOnClickListener {
               homeAdapter.datas.addAll(vm.initSimple())
               homeAdapter.notifyDataSetChanged()
          }
     }
     override fun initData(){
          homeAdapter = SimpleAdapter(vm.initSimple())
          ui.rvData.adapter = homeAdapter
     }
}