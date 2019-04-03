package com.hzcfapp.qmwallet.widget.recycler

/**
 * gaowenzhao
 */
enum class VHType( val s:String,val code:Int) {
    BANNER("Banner",0),
    ADVER("广告",1),
    AFFICHE("公告",2),
    NORMALENTRANCE("信息披露", 3),
    BID("标",4),
    HEADSECTION("headSection",5),
    INVESTMENTFLOW("投资流程",6),
    ZONGCOINMARKET("粽币商城",7),
    PLATFORMAD("平台实力",8),
    DIVER("item间隔",9),
    WHITEDIVER("白色的item间隔",10),
    DIVERLINE("分割线",11),
    QUICKWINDOW("便捷窗口",12),
    BOTTOMTEXT("底部文案",13),
    ERRORVIEW("缺省界面",14)
}