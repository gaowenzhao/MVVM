package com.zhao.base.inf

import androidx.lifecycle.ViewModel
import androidx.databinding.ViewDataBinding


abstract class BaseSimpleActivity<V : ViewDataBinding> : BaseActivity<V, ViewModel>()