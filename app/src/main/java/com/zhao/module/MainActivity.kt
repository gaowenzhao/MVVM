package com.zhao.module

import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.zhao.base.inf.BaseSimpleActivity
import com.zhao.module.databinding.MainActivityBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//import kotlinx.coroutines.*

class MainActivity : BaseSimpleActivity<MainActivityBinding>() {
    private val TAG = MainActivity::class.java.simpleName
    override var layoutId: Int = R.layout.main_activity
    override fun initView() {
        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        val navController = host.navController
        ui.navigationView.setupWithNavController(navController)
    }

    override fun initData() {
        Toast.makeText(this, "测试哈哈哈", Toast.LENGTH_SHORT).show()
//        test()
    }

    private fun test() {
         GlobalScope.launch(Dispatchers.Unconfined) {
             Log.d("AA", "协程1初始化完成，时间: " + System.currentTimeMillis())
             Log.d("AA", "协程1线程名字 :${Thread.currentThread().name}")
             for (i in 1..3) {
                 Log.d("AA", "协程1任务1打印第$i 次，时间: " + System.currentTimeMillis())
             }
             Log.d("AA", "协程1delay，时间: " + System.currentTimeMillis())
             delay(500)
             for (i in 1..3) {
                 Log.d("AA", "协程1任务2打印第$i 次，时间: " + System.currentTimeMillis())
             }
         }
        GlobalScope.launch(Dispatchers.Unconfined) {
            Log.d("AA", "协程2初始化完成，时间: " + System.currentTimeMillis())
            Log.d("AA", "协程2线程名字 :${Thread.currentThread().name}")
            for (i in 1..3) {
                Log.d("AA", "协程2任务1打印第$i 次，时间: " + System.currentTimeMillis())
            }
            Log.d("AA", "协程2delay，时间: " + System.currentTimeMillis())
            delay(500)
            for (i in 1..3) {
                Log.d("AA", "协程2任务2打印第$i 次，时间: " + System.currentTimeMillis())
            }
        }
         Log.d("AA", "主线程 sleep ，时间: " + System.currentTimeMillis())
         Thread.sleep(1000)
         Log.d("AA", "主线程运行，时间: " + System.currentTimeMillis())
         for (i in 1..3) {
             Log.d("AA", "主线程打印第$i 次，时间: " + System.currentTimeMillis())
         }
     }

}