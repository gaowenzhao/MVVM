package com.zhao.base.debug

import android.content.Intent
import com.zhao.base.R
import com.zhao.base.databinding.ActivityContainerBinding
import com.zhao.base.inf.BaseSimpleVMActivity

class ContainerVMActivity: BaseSimpleVMActivity<ActivityContainerBinding>(){
    override var layoutId: Int = R.layout.activity_container
    val FRAGMENT = "fragment"
    val BUNDLE = "bundle"
    override fun initView() {
        val fragment = initFromIntent(intent)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_content, fragment).commit()
    }
    override fun initData() {
    }
    private fun initFromIntent(data: Intent?): androidx.fragment.app.Fragment {
        if (data == null) {
            throw RuntimeException(
                "you must provide a page info to display"
            )
        }
        try {
            val fragmentName = data.getStringExtra(FRAGMENT)
            if (fragmentName == null || "" == fragmentName) {
                throw IllegalArgumentException("can not find page fragmentName")
            }
            val fragmentClass = Class.forName(fragmentName)
            val fragment = fragmentClass.newInstance() as androidx.fragment.app.Fragment
            val args = data.getBundleExtra(BUNDLE)
            if (args != null) {
                fragment.arguments = args
            }
            return fragment
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

        throw RuntimeException("fragment initialization failed!")
    }
}