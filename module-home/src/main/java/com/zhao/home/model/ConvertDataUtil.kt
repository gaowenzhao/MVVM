package com.zhao.home.model

import androidx.databinding.ObservableArrayList
import android.text.TextUtils
import android.util.SparseArray
import com.hzcf.model.base.error.BeanError
import com.hzcfapp.qmwallet.widget.recycler.MultipleFields
import com.hzcfapp.qmwallet.widget.recycler.VHType
import com.zhao.base.adapter.multityppe.MultiItemEntity
import com.zhao.home.R
import com.zhao.home.bean.BidBean
import com.zhao.home.bean.HeaderSectionBean
import com.zhao.home.bean.HomeDataBean

/**
 * gaowenzhao
 */
object ConvertDataUtil {
    const val MAXSPAN_SIZE = 24
    fun convertData(
        multiData: SparseArray<Any>
    ): ObservableArrayList<MultiItemEntity> {
        var datas: ObservableArrayList<MultiItemEntity> = ObservableArrayList()
        //banner
        val homeDataBean = multiData[0] as HomeDataBean
        for (banner in homeDataBean.banners) {
            banner.defaultImgRes = R.mipmap.ic_home_banner_default
        }
        addItem(VHType.BANNER.code, homeDataBean.banners, MAXSPAN_SIZE, datas)
        //adver 广告
        var advers = homeDataBean.advertisings
        if (advers != null && !advers.isEmpty()) {
            for (item in advers) {
                item.defaultImgRes = R.mipmap.ic_home_adver_default
            }
            addItem(VHType.ADVER.code, advers, MAXSPAN_SIZE, datas)
        }
        //公告
//        val afficheBean = multiData[1] as AfficheBean
//        addItem(VHType.AFFICHE.code, afficheBean, MAXSPAN_SIZE, datas)
        //信息披露、合众数据、新手奖励、签到有奖
        var normalEntrance = homeDataBean.normalEntrance
        if (normalEntrance != null && !normalEntrance.isEmpty()) {
            var entranceSize = normalEntrance.size
            for (item in normalEntrance) {
                addItem(VHType.NORMALENTRANCE.code, item, MAXSPAN_SIZE / entranceSize, datas)
            }
        }
        val bidList = multiData[2] as List<BidBean>
        for (item in bidList) {
            addItem(VHType.BID.code, item, MAXSPAN_SIZE, datas)
        }
        return datas
    }
    fun addMoreData(bidList:List<BidBean>):ObservableArrayList<MultiItemEntity>{
        val moreDatas = ObservableArrayList<MultiItemEntity>()
        for (item in bidList) {
            addItem(VHType.BID.code, item, MAXSPAN_SIZE, moreDatas)
        }
        return moreDatas
    }

    fun createDefaultData(state: BeanError.StateError): List<MultiItemEntity> {
        var datas: ArrayList<MultiItemEntity> = ArrayList()
        addItem(VHType.ERRORVIEW.code, state, MAXSPAN_SIZE, datas)
        return datas
    }

    private fun addSection(
        img: String,
        firstTitle: String,
        secondTitle: String,
        findAll: String = "",
        marketUrl: String = "",
        datas: ArrayList<MultiItemEntity>
    ) {
        val headerSectionBean = HeaderSectionBean(img, firstTitle, secondTitle)
        if (!TextUtils.isEmpty(findAll)) {
            headerSectionBean.marketUrl = marketUrl
            headerSectionBean.findAll = findAll
        }
        var entity = MultiItemEntity.builder()
            .setField(MultipleFields.ITEM_TYPE, VHType.HEADSECTION.code)
            .setField(MultipleFields.CONTENT, headerSectionBean)
            .setField(MultipleFields.SPAN_SIZE, MAXSPAN_SIZE)
            .build()
        datas.add(entity)
    }

    private fun addDiver(datas: ArrayList<MultiItemEntity>, vHType: Int = VHType.DIVER.code) {
        var entity = MultiItemEntity.builder()
            .setField(MultipleFields.ITEM_TYPE, vHType)
            .setField(MultipleFields.SPAN_SIZE, MAXSPAN_SIZE)
            .build()
        datas.add(entity)
    }

    private fun addDiverLine(datas: ArrayList<MultiItemEntity>) {
        var entity = MultiItemEntity.builder()
            .setField(MultipleFields.ITEM_TYPE, VHType.DIVERLINE.code)
            .setField(MultipleFields.SPAN_SIZE, MAXSPAN_SIZE)
            .build()
        datas.add(entity)
    }

    private fun addItem(
        vhType: Any,
        content: Any,
        spanSize: Int,
        datas: ArrayList<MultiItemEntity>,
        index: Int = 0
    ) {
        datas.add(
            MultiItemEntity.builder()
                .setField(MultipleFields.ITEM_TYPE, vhType)
                .setField(MultipleFields.CONTENT, content)
                .setField(MultipleFields.SPAN_SIZE, spanSize)
                .setField(MultipleFields.INDEX, index)
                .build()
        )
    }
}