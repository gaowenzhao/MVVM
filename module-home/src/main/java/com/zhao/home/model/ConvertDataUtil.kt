package com.zhao.home.model
import android.databinding.ObservableArrayList
import android.text.TextUtils
import android.util.SparseArray
import com.hzcf.model.base.error.BeanError
import com.hzcf.model.home.bean.AfficheBean
import com.hzcf.model.home.bean.BidBean
import com.hzcf.model.home.bean.HeaderSectionBean
import com.hzcf.model.home.bean.HomeDataBean
import com.hzcfapp.qmwallet.widget.recycler.MultipleFields
import com.hzcfapp.qmwallet.widget.recycler.VHType
import com.zhao.base.adapter.multityppe.MultiItemEntity
import com.zhao.home.R

/**
 * gaowenzhao
 */
object ConvertDataUtil {
    const val MAXSPAN_SIZE = 24
    fun convertData(
        multiData:SparseArray<Any>
        /*homeDataBean: HomeDataBean, afficheBean: AfficheBean, bidList: List<BidBean>,bottomText:String*/): ObservableArrayList<MultiItemEntity> {
        var datas: ObservableArrayList<MultiItemEntity> = ObservableArrayList()
        //banner
        val homeDataBean = multiData[0] as HomeDataBean
        for (banner in homeDataBean.banners) {
            banner.defaultImgRes = R.mipmap.ic_home_banner_default
        }
        addItem(VHType.BANNER.code, homeDataBean.banners, MAXSPAN_SIZE, datas)
        //adver 广告
        var advers = homeDataBean.advertisings
        if ( advers!= null && !advers.isEmpty()) {
            for (item in advers) {
                item.defaultImgRes = R.mipmap.ic_home_adver_default
            }
            addItem(VHType.ADVER.code, advers, MAXSPAN_SIZE, datas)
        }
        //公告
        val afficheBean = multiData[1] as AfficheBean
        addItem(VHType.AFFICHE.code, afficheBean, MAXSPAN_SIZE, datas)
        //信息披露、合众数据、新手奖励、签到有奖
        var normalEntrance = homeDataBean.normalEntrance
        if(normalEntrance!=null&&!normalEntrance.isEmpty()){
            var entranceSize = normalEntrance.size
            for (item in normalEntrance) {
                addItem(VHType.NORMALENTRANCE.code, item, MAXSPAN_SIZE / entranceSize, datas)
            }
        }
        addDiver(datas)
        //便捷窗口
        var facilewentryBean = homeDataBean.facilewentry
        if (facilewentryBean!=null){
            addSection(facilewentryBean.image,facilewentryBean.firstTitle,facilewentryBean.secondTitle,datas = datas)
            var facilewentrySize = facilewentryBean.facilewentry.size
            for (item in facilewentryBean.facilewentry){
                addItem(VHType.QUICKWINDOW.code, item, MAXSPAN_SIZE / facilewentrySize,  datas)
            }
        }
        //标列表
        addDiverLine(datas)
        val bidList = multiData[2] as List<BidBean>
        for (item in bidList) {
            addItem(VHType.BID.code, item, MAXSPAN_SIZE,  datas)
            addDiverLine(datas)
        }
        addDiver(datas)
        var investmentFlow = homeDataBean.investmentFlow
        if (investmentFlow != null) {
            //投资流程的section
            addSection(investmentFlow.image, investmentFlow.firstTitle, investmentFlow.secondTitle, datas = datas)
            //投资流程列表
            var buttonSize = investmentFlow.buttons.size
            for (index in investmentFlow.buttons.indices) {
                addItem(VHType.INVESTMENTFLOW.code, investmentFlow.buttons[index], MAXSPAN_SIZE / buttonSize, datas,index)
            }
            addDiver(datas)
        }
        //粽币商城的section
        var zongcoinmarket = homeDataBean.zongcoinmarket
        if(zongcoinmarket!=null){
            addSection(zongcoinmarket.image, zongcoinmarket.firstTitle, zongcoinmarket.secondTitle, zongcoinmarket.findAll!!, zongcoinmarket.marketUrl!!, datas)
            //粽币商城
            var marketButtonSize = zongcoinmarket.buttons.size
            for (index in zongcoinmarket.buttons.indices) {
                addItem(VHType.ZONGCOINMARKET.code, zongcoinmarket.buttons[index], MAXSPAN_SIZE / marketButtonSize, datas,index)
            }
            addDiver(datas)
        }
        //平台实力的section
        var platformad = homeDataBean.platformadvertisings
        if(platformad!=null){
            addSection(platformad.image, platformad.firstTitle, platformad.secondTitle, datas = datas)
            //平台实力列表
            for (item in platformad.advertisings) {
                addItem(VHType.PLATFORMAD.code, item, MAXSPAN_SIZE, datas)
            }
        }
        addDiver(datas,VHType.WHITEDIVER.code)
        val bottomText = multiData[3] as String
        addItem(VHType.BOTTOMTEXT.code,bottomText,MAXSPAN_SIZE,datas)
        return datas
    }
    fun createDefaultData(state: BeanError.StateError):List<MultiItemEntity>{
        var datas: ArrayList<MultiItemEntity> = ArrayList()
        addItem(VHType.ERRORVIEW.code, state, MAXSPAN_SIZE, datas)
        return datas
    }

    private fun addSection(img: String, firstTitle: String, secondTitle: String, findAll: String = "", marketUrl: String = "", datas: ArrayList<MultiItemEntity>) {
        val headerSectionBean = HeaderSectionBean(img, firstTitle, secondTitle)
        if (!TextUtils.isEmpty(findAll)) {
            headerSectionBean.marketUrl = marketUrl
            headerSectionBean.findAll = findAll
        }
        var entity = MultiItemEntity.builder()
                .setField(MultipleFields.VH_TYPE, VHType.HEADSECTION.code)
                .setField(MultipleFields.CONTENT, headerSectionBean)
                .setField(MultipleFields.SPAN_SIZE, MAXSPAN_SIZE)
                .build()
        datas.add(entity)
    }

    private fun addDiver(datas: ArrayList<MultiItemEntity>,vHType:Int=VHType.DIVER.code) {
        var entity = MultiItemEntity.builder()
                .setField(MultipleFields.VH_TYPE,vHType)
                .setField(MultipleFields.SPAN_SIZE, MAXSPAN_SIZE)
                .build()
        datas.add(entity)
    }

    private fun addDiverLine(datas: ArrayList<MultiItemEntity>) {
        var entity = MultiItemEntity.builder()
                .setField(MultipleFields.VH_TYPE, VHType.DIVERLINE.code)
                .setField(MultipleFields.SPAN_SIZE, MAXSPAN_SIZE)
                .build()
        datas.add(entity)
    }

    private fun addItem(vhType: Any, content: Any, spanSize: Int,datas: ArrayList<MultiItemEntity>,index:Int=0) {
        datas.add(MultiItemEntity.builder()
                .setField(MultipleFields.VH_TYPE, vhType)
                .setField(MultipleFields.CONTENT, content)
                .setField(MultipleFields.SPAN_SIZE, spanSize)
                .setField(MultipleFields.INDEX,index)
                .build())
    }
}