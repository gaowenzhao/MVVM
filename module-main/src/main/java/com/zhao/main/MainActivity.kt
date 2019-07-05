package com.zhao.main

import android.support.v4.app.Fragment
import com.zhao.base.inf.BaseFragment
import com.zhao.base.inf.BaseSimpleActivity
import com.zhao.base.utils.router.RouterClient
import com.zhao.base.utils.router.RouterUrl
import com.zhao.main.databinding.MainActivityBinding

class MainActivity : BaseSimpleActivity<MainActivityBinding>() {
    private val TAG = MainActivity::class.java.simpleName
    override var layoutId: Int = R.layout.main_activity
    //装fragment的实例集合
    private lateinit var fragments: ArrayList<BaseFragment<*, *>>
    private var position = 0

    override fun initView() {
        initFragment()
        initListener()
    }
    override fun initData() {
    }
    private fun initFragment() {
        //ARouter拿到多Fragment(这里需要通过ARouter获取，不能直接new,因为在组件独立运行时，宿主app是没有依赖其他组件，所以new不到其他组件的Fragment)
        val homeFragment = RouterClient.start(RouterUrl.Home.TabHome) as BaseFragment<*, *>
        val msgFragment = RouterClient.start(RouterUrl.Msg.TabMsg) as BaseFragment<*, *>
        val userFragment = RouterClient.start(RouterUrl.User.TabUser) as BaseFragment<*, *>
        fragments = ArrayList()
        fragments.add(homeFragment)
        fragments.add(msgFragment)
        fragments.add(userFragment)
        //默认选中第一个
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, homeFragment)
        transaction.commitAllowingStateLoss()
    }

    private fun initListener() {
        ui.rgMain.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_home ->  {
                    switchFragment(fragments[position], fragments[0])
                    position = 0
                }
                R.id.rb_msg  ->  {
                    switchFragment(fragments[position], fragments[1])
                    position = 1
                }
                R.id.rb_user ->  {
                    switchFragment(fragments[position], fragments[2])
                    position = 2
                }

            }

        }
    }

    private fun switchFragment(hideFragment: Fragment, showFragment: BaseFragment<*, *>) {
        if (hideFragment !== showFragment) {
            val transaction = supportFragmentManager.beginTransaction()
            //判断nextFragment是否添加成功
            if (!showFragment.isAdded) {
                //隐藏当前的Fragment
                 transaction.hide(hideFragment)
                //添加Fragment
                transaction.add(R.id.container, showFragment).commitAllowingStateLoss()
            } else {
                //隐藏当前Fragment
                if (hideFragment != null) {
                    transaction.hide(hideFragment)
                }
                transaction.show(showFragment).commitAllowingStateLoss()
            }
        }
    }
}