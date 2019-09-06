package com.zhao.msg.debug

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.zhao.base.debug.ContainerVMActivity
import com.zhao.msg.MsgVMFragment

class DebugActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, ContainerVMActivity::class.java)
        intent.putExtra("fragment", MsgVMFragment::class.java!!.canonicalName)
        this.startActivity(intent)
        finish()
    }
}