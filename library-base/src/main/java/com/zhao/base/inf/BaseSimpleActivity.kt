package com.zhao.base.inf

import android.arch.lifecycle.ViewModel
import android.databinding.ViewDataBinding

abstract class BaseSimpleActivity<V : ViewDataBinding> : BaseActivity<V,ViewModel>()