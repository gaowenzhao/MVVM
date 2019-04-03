package com.zhao.base.inf

import android.arch.lifecycle.ViewModel
import android.databinding.ViewDataBinding

abstract class BaseSimpleFragment<V : ViewDataBinding> : BaseFragment<V,ViewModel>()