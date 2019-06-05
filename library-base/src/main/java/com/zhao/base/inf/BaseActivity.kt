package com.zhao.base.inf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.gyf.immersionbar.ktx.immersionBar
import com.zhao.base.R
import com.zhao.base.utils.eventbus.EventBusUtil
import java.lang.reflect.ParameterizedType

/**
 * BaseActivity父类
 */
abstract class BaseActivity<V : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {
    open var isEventbus = false
    open var darkMode: Boolean = false
    open var fitsSystemWindows = false
    open var statusBarColor = R.color.white
    lateinit var context: Context
    abstract var layoutId: Int
    lateinit var ui: V
    val vm by lazy {
        ViewModelProviders.of(this).get(getClassType())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        ui = DataBindingUtil.setContentView(this, layoutId)
        if (isEventbus) {
            EventBusUtil.register(this)
        }
        immersionBar {
            statusBarColor(statusBarColor)
            statusBarDarkFont(darkMode, 0.2f)
            fitsSystemWindows(fitsSystemWindows)
        }
        initView()
        initData()
    }

    protected abstract fun initView()
    protected abstract fun initData()
    override fun onDestroy() {
        super.onDestroy()
        if (isEventbus) {
            EventBusUtil.unregister(this)
        }
    }

    private fun getClassType(): Class<VM> {
        val genType = this.javaClass.genericSuperclass
        val actualTypeArgs = (genType as ParameterizedType).actualTypeArguments
        return actualTypeArgs[1] as Class<VM>
    }
}
