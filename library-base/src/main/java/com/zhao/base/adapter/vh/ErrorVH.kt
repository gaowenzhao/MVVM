package com.zhao.base.adapter.vh

import android.view.ViewGroup
import com.hzcf.model.base.error.BeanError
import com.zhao.base.R
import com.zhao.base.adapter.BaseViewHolder
import com.zhao.base.databinding.IncErrorBinding

class ErrorVH(vg:ViewGroup):BaseViewHolder<IncErrorBinding,BeanError>(R.layout.inc_error,vg){
    override fun bindData() {
        ui.error = mData
    }
}