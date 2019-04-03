package com.zhao.home.vm

import android.arch.lifecycle.MutableLiveData
import com.hzcfapp.qmwallet.widget.recycler.VHType
import com.zhao.base.adapter.multityppe.MultiItemEntity
import com.zhao.base.http.BaseObs
import com.zhao.base.http.bean.BaseBean
import com.zhao.base.inf.BaseVM
import com.zhao.base.utils.VMUtil
import com.zhao.home.model.HomeModel
import com.zhao.home.vm.rv.AdverVM
import com.zhao.home.vm.rv.BannerVM

class HomeVM :BaseVM(){
    private val homeModel = HomeModel()
    var title = MutableLiveData<String>().apply { value = "首页test" }
    fun getBannerList() {
        addSubscription(homeModel.getBannerList(object : BaseObs<Any>(){
            override fun onSuccess(t: BaseBean<Any>, data: Any?) {

            }
        }))
    }
    fun initData():ArrayList<MultiItemEntity>{
       var datas = ArrayList<MultiItemEntity>()
       val bannerEntity =  MultiItemEntity.builder()
            .setSpanSize(2)
            .setVhType(VHType.BANNER.code)
            .setContent(VMUtil.createVM(BannerVM::class.java))
            .build()
        datas.add(bannerEntity)

        val adverEntity =  MultiItemEntity.builder()
            .setSpanSize(1)
            .setVhType(VHType.ADVER.code)
            .setContent(VMUtil.createVM(AdverVM::class.java))
            .build()
        datas.add(adverEntity)

        val adverEntity1 =  MultiItemEntity.builder()
            .setSpanSize(1)
            .setVhType(VHType.ADVER.code)
            .setContent(VMUtil.createVM(AdverVM::class.java))
            .build()
        datas.add(adverEntity1)
        return datas
    }
}