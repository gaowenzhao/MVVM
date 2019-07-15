package com.zhao.module

import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.zhao.base.inf.BaseSimpleActivity
import com.zhao.module.databinding.MainActivityBinding

class MainActivity : BaseSimpleActivity<MainActivityBinding>() {
    private val TAG = MainActivity::class.java.simpleName
    override var layoutId: Int = R.layout.main_activity
    override fun initView() {
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        val navController = host.navController
        ui.navigationView.setupWithNavController(navController)
    }

    override fun initData() {
        Toast.makeText(this,"测试哈哈哈", Toast.LENGTH_SHORT).show()
    }
}