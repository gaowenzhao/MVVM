package com.hzcf.model.base.error

import com.zhao.base.R


open class BeanError(var state: StateError = StateError.NONE) {

  //  var msg = state.msg
  //  var ic = state.ic
  //  var msgBt = state.msgBt

  enum class StateError(val msg: String? = null, val ic: Int = R.mipmap.ic_error_data, val msgBt: String? = null, val visible: Boolean = true) {
    NONE(visible = false),
    OFF_LINE("没有连接到网络", R.mipmap.ic_error_offline, "刷新"),
    NO_DATA("暂无数据", R.mipmap.ic_error_data, "刷新"),
    NO_CALLBACK("请求数据失败，请重新加载", R.mipmap.ic_error_data, "刷新"),
    NO_MSG("暂无消息", R.mipmap.ic_error_msg),
    NO_YOUHUI("暂无优惠券", R.mipmap.ic_error_coupon),
    NO_CHUJIE("暂无出借记录", R.mipmap.ic_error_record, "去出借"),
    NO_SANBIAO("暂无散标", R.mipmap.ic_error_record),
    NO_ziyingcun("暂无自盈存Plus", R.mipmap.ic_error_record),
    NO_ZAIZHUAN("暂无债转", R.mipmap.ic_error_record),
    NO_JIAOYI("暂无交易记录", R.mipmap.ic_error_record),
    NO_HUIKUAN("暂无回款", R.mipmap.ic_error_record)
  }

  fun update(state: StateError): BeanError {
    this.state = state
//    msg = state.msg
//    ic = state.ic
//    msgBt = state.msgBt
    return this
  }

  //================ ==================
  open fun onRefresh() {

  }
}