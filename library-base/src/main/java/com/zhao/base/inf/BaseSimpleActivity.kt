package com.zhao.base.inf

import android.arch.lifecycle.ViewModel
import android.databinding.ViewDataBinding
import com.zhao.base.presenter.BasePresenter

abstract class BaseSimpleActivity<V : ViewDataBinding> : BaseVMActivity<V,ViewModel>()