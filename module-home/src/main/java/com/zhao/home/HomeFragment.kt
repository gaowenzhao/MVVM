package com.zhao.home

import android.Manifest
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.zhao.base.inf.BaseFragment
import com.zhao.base.utils.permission.BasePermissionI
import com.zhao.base.utils.permission.PermissionUtils
import com.zhao.base.utils.router.RouterUrl
import com.zhao.home.databinding.FragmentHomeBinding
import com.zhao.home.rv.SimpleAdapter
import com.zhao.home.vm.HomeVM

@Route(path = RouterUrl.Home.TabHome)
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>(),BasePermissionI{
     override var darkMode: Boolean = false
     override var fitsSystemWindows: Boolean = true
     override var layoutId: Int = R.layout.fragment_home
     override var statusBarColor: Int = R.color.colorPrimary
     private  val homeAdapter by lazy { SimpleAdapter() }
     override fun initVM() {
         ui.vm = vm
     }
     override fun initView(RootView: View) {
          var manager = LinearLayoutManager(context)
          ui.rvData.layoutManager = manager
          ui.tvTitle.setOnClickListener {
               homeAdapter.addAll(vm.initSimple())
          }
         ui.rvData.adapter = homeAdapter
     }
     override fun initData(){
          PermissionUtils.requestPermission(activity!!,this,Manifest.permission.READ_PHONE_STATE)
     }
     override fun onGranted() {
          homeAdapter.update(vm.initSimple())
     }
    companion object {
        const val TAG = "HomeFragment"
    }
}