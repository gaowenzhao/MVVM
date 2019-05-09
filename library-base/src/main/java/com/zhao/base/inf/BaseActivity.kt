package com.zhao.base.inf

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.gyf.barlibrary.ImmersionBar
import com.zhao.base.utils.eventbus.EventBusUtil
import java.lang.reflect.ParameterizedType

/**
 * BaseActivity父类
 */
abstract class BaseActivity<V : ViewDataBinding,VM:ViewModel> : AppCompatActivity(){
    open var isEventbus = false
    lateinit var context: Context
    abstract var layoutId: Int
    lateinit var ui: V
    val vm by lazy {
        ViewModelProviders.of(this).get(getClassType())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        ui = DataBindingUtil.setContentView(this,layoutId)
        if (isEventbus) {
            EventBusUtil.register(this)
        }
        ImmersionBar.with(this).init()
        initView()
        initData()
    }
    protected abstract fun initView()
    protected abstract fun initData()
    override fun onDestroy() {
        if (isEventbus) {
            EventBusUtil.unregister(this)
        }
        super.onDestroy()
    }

    private fun getClassType(): Class<VM> {
        val genType = this.javaClass.genericSuperclass
        val actualTypeArgs = (genType as ParameterizedType).actualTypeArguments
        return actualTypeArgs[1] as Class<VM>
    }
}
