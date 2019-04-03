package com.zhao.base.inf

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Build
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gyf.barlibrary.ImmersionBar
import com.gyf.barlibrary.SimpleImmersionFragment
import com.zhao.base.R
import com.zhao.base.utils.eventbus.EventBusUtil
import java.lang.reflect.ParameterizedType


/**
 * Fragment父类
 */
abstract class BaseFragment<V : ViewDataBinding, VM : ViewModel> : SimpleImmersionFragment() {
    open var isEventbus = false
    var mRootView: View? = null
    lateinit var mContext: Context
    abstract var layoutId: Int
    open var darkMode: Boolean = false
    open var fitsSystemWindows = false
    open var statusBarColor = R.color.white
    lateinit var ui: V
    val vm by lazy {
        ViewModelProvider.AndroidViewModelFactory.getInstance(activity?.application!!).create(getClassType())
    }
    /**
     * 绑定activity
     *
     * @param context
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (null == mRootView) {
            ui = DataBindingUtil.inflate(inflater, layoutId, container, false)
            mRootView = ui.root
        } else {
            val parent = mRootView!!.parent as ViewGroup
            parent.removeView(mRootView)
        }
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val childView = (activity?.findViewById(android.R.id.content) as ViewGroup).getChildAt(0)
        if (view != null) {
            ViewCompat.requestApplyInsets(childView)
        }
        if (null == mRootView) {
            mRootView = view
        }
        if (isEventbus) {
            EventBusUtil.register(this)
        }
        initUIVM()
        initView(mRootView!!)
        initData()
    }

    override fun initImmersionBar() {
        ImmersionBar.with(this)
            .statusBarColor(statusBarColor)
            .statusBarDarkFont(darkMode, 0.2f)
            .fitsSystemWindows(fitsSystemWindows)
            .navigationBarColor(R.color.c_3c4f5e)
            .init()
    }
    private fun getClassType(): Class<VM> {
        val genType = this.javaClass.genericSuperclass
        val actualTypeArgs = (genType as ParameterizedType).actualTypeArguments
        return actualTypeArgs[1] as Class<VM>
    }
    /**
     * 在这里实现Fragment数据的缓加载.
     *
     * @param isVisibleToUser
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && activity != null) {
            onUserVisible()
        } else {
            onUserInvisible()
        }
    }
    override fun onDestroy() {
        if (isEventbus) {
            EventBusUtil.unregister(this)
        }
        super.onDestroy()
    }

    override fun getContext(): Context {
        if (null == mContext) {
            mContext = activity!!
        }
        return mContext
    }

    protected  open fun initData(){ }
    protected open fun initView(RootView: View){}
    /**
     * 显示加载（除了首次）
     */
    protected open fun onUserVisible() {}
    protected open fun onUserInvisible() {}
    protected open fun initUIVM(){}
}
