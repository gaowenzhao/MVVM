package com.zhao.base.inf

import android.databinding.ViewDataBinding

abstract class BaseSimpleFragment<V : ViewDataBinding> : BaseFragment<V,BaseVM>()