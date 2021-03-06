package com.zhao.home

import android.util.Log
import android.view.View
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.GridLayoutManager
import com.zhao.base.adapter.multityppe.MultiItemEntity
import com.zhao.base.inf.BaseFragment
import com.zhao.home.databinding.FragmentHomeBinding
import com.zhao.home.model.ConvertDataUtil.MAXSPAN_SIZE
import com.zhao.home.rv.HomeAdapter
import com.zhao.home.vm.HomeVM

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>(),HomeVM.VMCallBack{
    override fun loadMore(data: ObservableArrayList<MultiItemEntity>) {
        ui.refreshlayout.finishLoadMore()
        homeAdapter.datas.addAll(data)
    }
    override fun updateData(t: ObservableArrayList<MultiItemEntity>) {
        homeAdapter.setNewData(t)
        ui.refreshlayout.finishRefresh()
    }

    override var darkMode: Boolean = true
     override var fitsSystemWindows: Boolean = true
     override var layoutId: Int = R.layout.fragment_home
     override var statusBarColor: Int = R.color.white
     private  val homeAdapter by lazy { HomeAdapter() }

     override fun initVM() {
         ui.vm = vm
         vm.vmCallBack = this
     }
     override fun initView(RootView: View) {
         ui.rvData.layoutManager = GridLayoutManager(activity, MAXSPAN_SIZE)
         ui.rvData.adapter = homeAdapter
         ui.refreshlayout.setOnRefreshListener {
           vm.getAllData()
         }
         ui.refreshlayout.setOnLoadMoreListener {
            vm.getBidList(true)
         }
     }
     override fun initData(){
         Log.i("LoginAspect","HomeFragment.initData1")
         vm.getAllData()
     }

    override fun onDestroy() {
        super.onDestroy()
        vm.vmCallBack = null
    }
    companion object {
        val TAG = HomeFragment::class.java.simpleName
    }
}