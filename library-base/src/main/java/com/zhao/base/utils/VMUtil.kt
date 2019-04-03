package com.zhao.base.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.zhao.base.app.BaseApplication

object VMUtil{
    fun <T:ViewModel> createVM(clazz: Class<T>):T{
        return ViewModelProvider.AndroidViewModelFactory.getInstance(BaseApplication.instance!!).create(clazz)
    }
}
