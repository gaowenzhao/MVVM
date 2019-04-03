package com.zhao.home.vm

import android.arch.lifecycle.MutableLiveData
import com.zhao.base.http.BaseObs
import com.zhao.base.http.bean.BaseBean
import com.zhao.base.inf.BaseVM
import com.zhao.home.model.HomeModel

class HomeVM :BaseVM(){
    private val homeModel = HomeModel()
    var title = MutableLiveData<String>()
    fun initData(){
        title.value = "首页test"
        getBannerList()
    }
    fun getBannerList() {
        addSubscription(homeModel.getBannerList(object : BaseObs<Any>(){
            override fun onSuccess(t: BaseBean<Any>, data: Any?) {

            }
        }))
    }
}