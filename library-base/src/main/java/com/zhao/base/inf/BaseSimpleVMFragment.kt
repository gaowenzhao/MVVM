package com.zhao.base.inf

import androidx.databinding.ViewDataBinding

abstract class BaseSimpleVMFragment<V : ViewDataBinding> : BaseVMFragment<V,BaseVM>()