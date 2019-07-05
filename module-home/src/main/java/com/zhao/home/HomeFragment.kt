package com.zhao.home

import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.zhao.base.inf.BaseFragment
import com.zhao.base.utils.router.RouterUrl
import com.zhao.home.databinding.FragmentHomeBinding
import com.zhao.home.model.ConvertDataUtil.MAXSPAN_SIZE
import com.zhao.home.rv.HomeAdapter
import com.zhao.home.vm.HomeVM
@Route(path = RouterUrl.Home.TabHome)
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>(){
     override var darkMode: Boolean = true
     override var fitsSystemWindows: Boolean = true
     override var layoutId: Int = R.layout.fragment_home
     override var statusBarColor: Int = R.color.white
     private  val homeAdapter by lazy { HomeAdapter(vm.homeDatas) }

     override fun initVM() {
         ui.vm = vm
     }
     override fun initView(RootView: View) {
         ui.rvData.layoutManager = GridLayoutManager(activity, MAXSPAN_SIZE)
         ui.rvData.adapter = homeAdapter
     }
     override fun initData(){
         vm.getAllData()
     }

    companion object {
        val TAG = HomeFragment::class.java.simpleName
    }
}