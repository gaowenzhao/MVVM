package com.zhao.home

import android.Manifest
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.zhao.base.inf.BaseFragment
import com.zhao.base.utils.CopyBeanUtils
import com.zhao.base.utils.LogUtils
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
          PermissionUtils.requestPermission(activity!!,this,Manifest.permission.READ_PHONE_STATE)
          test()
     }
     override fun onGranted() {
          homeAdapter = SimpleAdapter(vm.initSimple())
          ui.rvData.adapter = homeAdapter
     }
    fun test(){
        var toBean = CopyBeanUtils.copy(FromBean(), ToBean())
        LogUtils.i(TAG,toBean.toString())
    }
    class FromBean{
        var img = "1111111"
        var date = "22222222"
        var time = 1213212
        var text = "高文昭"
    }

    class ToBean{
        var img = ""
        var date = ""
        var time:Long = 0
        var text = ""
        override fun toString(): String {
            return "ToBean(img='$img', date='$date', time=$time, text='$text')"
        }
    }

    companion object {
        const val TAG = "HomeFragment"
    }
}