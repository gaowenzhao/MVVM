package com.zhao.home.rv.vh

import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.zhao.base.adapter.BaseViewHolder
import com.zhao.base.app.BaseApplication
import com.zhao.base.aspect.CheckLogin
import com.zhao.base.inf.Clicker
import com.zhao.home.R
import com.zhao.home.bean.BidBean
import com.zhao.home.databinding.HomeItemBidBinding


class BidVH(vg: ViewGroup) : BaseViewHolder<HomeItemBidBinding,BidBean>(R.layout.home_item_bid,vg),Clicker{
    override fun onClick(v: View?) {
        testAspect()
        mData.buttonText = "高溫找"
    }

    override fun bindData() {
         ui.clicker = this
         ui.bean = mData
    }
    @CheckLogin
    fun testAspect(){
        Toast.makeText(BaseApplication.appContext,"testAspect",Toast.LENGTH_SHORT).show()
    }
}
