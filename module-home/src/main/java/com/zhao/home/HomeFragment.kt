package com.zhao.home

import android.databinding.ObservableArrayList
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.zhao.base.adapter.multityppe.MultiItemEntity
import com.zhao.base.inf.BaseFragment
import com.zhao.base.utils.router.RouterUrl
import com.zhao.home.databinding.FragmentHomeBinding
import com.zhao.home.model.ConvertDataUtil.MAXSPAN_SIZE
import com.zhao.home.rv.HomeAdapter
import com.zhao.home.vm.HomeVM

@Route(path = RouterUrl.Home.TabHome)
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>(),HomeVM.VMCallBack{
    override var darkMode: Boolean = true
     override var fitsSystemWindows: Boolean = true
     override var layoutId: Int = R.layout.fragment_home
     override var statusBarColor: Int = R.color.white
     private  val homeAdapter by lazy { HomeAdapter() }
     override fun initVM() {
         ui.vm = vm
     }
     override fun initView(RootView: View) {
         ui.rvData.layoutManager = GridLayoutManager(activity,MAXSPAN_SIZE)
         ui.rvData.adapter = homeAdapter
         vm.vmCallBack = this
     }
     override fun initData(){
         vm.getAllData()
     }
    override fun onSuccess(data: ObservableArrayList<MultiItemEntity>) {
        homeAdapter.update(data)
    }
    companion object {
        val TAG = HomeFragment::class.java.simpleName
    }
}