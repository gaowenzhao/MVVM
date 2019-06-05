package com.zhao.base.inf

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseSimpleActivity<V : ViewDataBinding> : BaseActivity<V,ViewModel>()