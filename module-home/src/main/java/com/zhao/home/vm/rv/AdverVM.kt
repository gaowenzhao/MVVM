package com.zhao.home.vm.rv

import android.arch.lifecycle.MutableLiveData
import com.zhao.base.inf.BaseVM

class AdverVM :BaseVM(){
    var adver = MutableLiveData<String>().apply { value = "adver" }
}