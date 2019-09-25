package com.zhao.home.vm

import android.util.SparseArray
import androidx.databinding.ObservableArrayList
import com.hzcfapp.qmwallet.widget.recycler.MultipleFields
import com.zhao.base.adapter.multityppe.MultiItemEntity
import com.zhao.base.http.BaseObs
import com.zhao.base.inf.BaseVM
import com.zhao.base.rx.SimplaObserver
import com.zhao.home.bean.AfficheBean
import com.zhao.home.bean.BidBean
import com.zhao.home.bean.HomeDataBean
import com.zhao.home.model.ConvertDataUtil
import com.zhao.home.model.HomeModel

class HomeVM : BaseVM() {
    private val mod = HomeModel()
    lateinit var vmCallBack:VMCallBack
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

     fun getBidList(loadmore:Boolean = false) {
        sub(mod.getBidList(object : BaseObs<ArrayList<BidBean>>() {
            override fun onSuccess(data: ArrayList<BidBean>?) {
                if(loadmore){
                    vmCallBack.loadMore(ConvertDataUtil.addMoreData(data!!))
                }else{
                    multiData.put(2,data)
                    mod.convertData(multiData,object :SimplaObserver<ObservableArrayList<MultiItemEntity>>(){
                        override fun onNext(t: ObservableArrayList<MultiItemEntity>) {
                            vmCallBack.updateData(t)
                        }
                    })
                }
            }
        }))
    }

    private fun getBottomText() {
        sub(mod.getBottomText(object : BaseObs<String>() {
            override fun onSuccess(data: String?) {
                multiData.put(3,data)
                mod.convertData(multiData,object :SimplaObserver<ObservableArrayList<MultiItemEntity>>(){
                    override fun onNext(t: ObservableArrayList<MultiItemEntity>) {
                        vmCallBack.updateData(t)
                    }
                })
            }
        }))
    }
    interface VMCallBack{
        fun updateData(t: ObservableArrayList<MultiItemEntity>)
        fun loadMore(data: ObservableArrayList<MultiItemEntity>)
    }
}