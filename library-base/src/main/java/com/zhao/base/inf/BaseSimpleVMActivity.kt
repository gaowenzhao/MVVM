package com.zhao.base.inf

import androidx.lifecycle.ViewModel
import androidx.databinding.ViewDataBinding


abstract class BaseSimpleVMActivity<V : ViewDataBinding> : BaseVMActivity<V, ViewModel>()