package com.zhao.home.vm

import android.util.SparseArray
import androidx.databinding.ObservableArrayList
import com.zhao.base.adapter.multityppe.MultiItemEntity
import com.zhao.base.http.BaseObs
import com.zhao.base.http.bean.BaseBean
import com.zhao.base.inf.BaseVM
import com.zhao.base.rx.SimplaObserver
import com.zhao.base.utils.LogUtils
import com.zhao.home.bean.AfficheBean
import com.zhao.home.bean.BidBean
import com.zhao.home.bean.HomeDataBean
import com.zhao.home.model.HomeModel

class HomeVM : BaseVM() {
    private val mod = HomeModel()
    var homeDatas: ObservableArrayList<MultiItemEntity> = ObservableArrayList()
    private val multiData = SparseArray<Any>()
    fun getAllData() {
        getHomeInfo()
    }

    private fun getHomeInfo() {
       sub(mod.getHomeInfo(object : BaseObs<HomeDataBean>() {
            override fun onSuccess(data: HomeDataBean?) {
                multiData.put(0,data)
                getAffiche()
            }
         }
        ))
    }
    private fun getAffiche() {
        sub(mod.getAffiche(object : BaseObs<AfficheBean>() {
            override fun onSuccess(data: AfficheBean?) {
                multiData.put(1,data)
                getBidList()
            }
        }))
    }

    private fun getBidList() {
        sub(mod.getBidList(object : BaseObs<ArrayList<BidBean>>() {
            override fun onSuccess(data: ArrayList<BidBean>?) {
                data?.addAll(data)
                data?.addAll(data)
                data?.addAll(data)
                data?.addAll(data)
                multiData.put(2,data)
                getBottomText()
            }
        }))
    }

    private fun getBottomText() {
        sub(mod.getBottomText(object : BaseObs<String>() {
            override fun onSuccess(data: String?) {
                multiData.put(3,data)
                mod.convertData(multiData,object :SimplaObserver<ObservableArrayList<MultiItemEntity>>(){
                    override fun onNext(t: ObservableArrayList<MultiItemEntity>) {
                        updateData(t)
                    }
                })
            }

            override fun onError(t: BaseBean<String>) {
                super.onError(t)
                LogUtils.i("test","test")
            }

            override fun onError(e: Throwable) {
                super.onError(e)
                LogUtils.i("test","test")
            }
        }))
    }
    private fun updateData(t: ObservableArrayList<MultiItemEntity>){
        homeDatas.clear()
        homeDatas.addAll(t)
    }

}