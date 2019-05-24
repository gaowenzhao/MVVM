package com.zhao.home.vm

import android.databinding.ObservableArrayList
import android.util.SparseArray
import com.zhao.base.adapter.multityppe.MultiItemEntity
import com.zhao.base.http.BaseObs
import com.zhao.base.inf.BaseVM
import com.zhao.home.bean.AfficheBean
import com.zhao.home.bean.BidBean
import com.zhao.home.bean.HomeDataBean
import com.zhao.home.model.HomeModel
import io.reactivex.observers.DisposableObserver

class HomeVM : BaseVM() {
    var vmCallBack:VMCallBack? = null
    private val mod = HomeModel()
    private val multiData = SparseArray<Any>()

    fun getAllData() {
        getHomeInfo()
    }
   private fun getHomeInfo() {
        mod.getHomeInfo(object : BaseObs<HomeDataBean>() {
            override fun onSuccess(data: HomeDataBean?) {
                multiData.put(0,data)
                getAffiche()
            }
         }
        )
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
        sub(mod.getBidList(object : BaseObs<List<BidBean>>() {
            override fun onSuccess(data: List<BidBean>?) {
                multiData.put(2,data)
                getBottomText()
            }
        }))
    }

    private fun getBottomText() {
        sub(mod.getBottomText(object : BaseObs<String>() {
            override fun onSuccess(data: String?) {
                multiData.put(3,data)
                mod.convertData(multiData,object : DisposableObserver<ObservableArrayList<MultiItemEntity>>(){
                    override fun onComplete() {}
                    override fun onError(e: Throwable) {}
                    override fun onNext(t: ObservableArrayList<MultiItemEntity>) {
                        vmCallBack?.onSuccess(t)
                    }
                })
            }
        }))
    }
    interface VMCallBack {
        fun onSuccess(data:ObservableArrayList<MultiItemEntity>)
    }
}