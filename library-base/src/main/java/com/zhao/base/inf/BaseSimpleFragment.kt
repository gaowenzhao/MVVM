package com.zhao.base.inf

import androidx.databinding.ViewDataBinding

abstract class BaseSimpleFragment<V : ViewDataBinding> : BaseFragment<V,BaseVM>()