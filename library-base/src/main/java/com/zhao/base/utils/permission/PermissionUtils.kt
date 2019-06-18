package com.zhao.base.utils.permission

import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.CAMERA
import android.Manifest.permission.GET_ACCOUNTS
import android.Manifest.permission.PROCESS_OUTGOING_CALLS
import android.Manifest.permission.READ_CALL_LOG
import android.Manifest.permission.READ_CONTACTS
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.READ_PHONE_STATE
import android.Manifest.permission.READ_SMS
import android.Manifest.permission.RECEIVE_MMS
import android.Manifest.permission.RECEIVE_SMS
import android.Manifest.permission.RECEIVE_WAP_PUSH
import android.Manifest.permission.SEND_SMS
import android.Manifest.permission.USE_SIP
import android.Manifest.permission.WRITE_CALL_LOG
import android.Manifest.permission.WRITE_CONTACTS
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.app.Activity
import android.content.Context
import android.support.v7.app.AlertDialog
import android.text.TextUtils
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.Permission.ACCESS_COARSE_LOCATION
import com.yanzhenjie.permission.Permission.ACCESS_FINE_LOCATION
import com.yanzhenjie.permission.Permission.RECORD_AUDIO
import com.zhao.base.R
import com.zhao.base.app.BaseApplication
import java.util.*

/**
 * Created by RGghjhgj on 2018/7/3.
 */

object PermissionUtils {
    fun requestPermission(activity: Activity,permissionI: BasePermissionI,vararg permissions: String) {
        AndPermission.with(BaseApplication.appContext)
            .runtime()
            .permission(*permissions)
            .onGranted {
                permissionI.onGranted()
            }
            .onDenied { data ->
                if (AndPermission.hasAlwaysDeniedPermission(activity)) {
                    showPermissionWindow(activity, data)
                }
            }.start()
    }

    fun showPermissionWindow(context: Context, permissions: List<String>, cancelable: Boolean = false) {
        if (cancelable) {
            val permissionNames = transformText(permissions)
            val content = context.getString(R.string.permission_desc, TextUtils.join(" ", permissionNames))
            val settingService = AndPermission.with(context).runtime()
            AlertDialog.Builder(context)
                .setTitle("权限提示")
                .setCancelable(false)
                .setMessage(content)
                .setPositiveButton("同意") { _, _ ->

                }
                .show()
        } else {
            showPermissionWindow(context, permissions)
        }
    }

    /**
     * Turn permissions into text.
     */
    private fun transformText(permissions: List<String>): List<String> {
        val textList = ArrayList<String>()
        var message = ""
        for (permission in permissions) {
            when (permission) {
                CAMERA -> message = BaseApplication.appContext.getString(R.string.permission_camera)
                READ_CONTACTS, WRITE_CONTACTS, GET_ACCOUNTS ->
                    message = BaseApplication.appContext.getString(R.string.permission_contacts)
                ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION ->
                    message =
                        BaseApplication.appContext.getString(com.yanzhenjie.permission.R.string.permission_name_location)
                RECORD_AUDIO ->
                    message =
                        BaseApplication.appContext.getString(com.yanzhenjie.permission.R.string.permission_name_microphone)
                READ_PHONE_STATE, CALL_PHONE, READ_CALL_LOG, WRITE_CALL_LOG, USE_SIP, PROCESS_OUTGOING_CALLS ->
                    message = BaseApplication.appContext.getString(R.string.permission_phone)
                SEND_SMS, RECEIVE_SMS, READ_SMS, RECEIVE_WAP_PUSH, RECEIVE_MMS ->
                    message = BaseApplication.appContext.getString(R.string.permission_sms)
                READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE ->
                    message = BaseApplication.appContext.getString(R.string.permission_storage)
            }
            if (!message.isNullOrBlank() && !textList.contains(message)) {
                textList.add(message)
            }
        }
        return textList
    }

}
