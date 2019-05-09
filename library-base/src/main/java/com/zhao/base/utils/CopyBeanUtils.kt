package com.zhao.base.utils

import java.lang.Exception
import java.lang.reflect.Field

object CopyBeanUtils {
    val TAG = CopyBeanUtils::class.java.simpleName
    fun copy(fromObject: Any, toObject: Any): Any {
        var fromClzz = fromObject.javaClass
        var toClzz = toObject.javaClass
        val toFields = toClzz.declaredFields
        for (toField in toFields) {
            val name = toField.name
                val fromField = getField(fromClzz,name)
                if(fromField!=null){
                    fromField.isAccessible = true
                    val value = fromField.get(fromObject)
                    toField.isAccessible = true
                    toField.set(toObject, value)
                }
        }
        return toObject
    }

    private fun getField(clazz: Class<Any>,name: String):Field?{
        try {
           return clazz.getDeclaredField(name)
        }catch (e:Exception){
        }
        return null
    }
    private fun hasroperty(obj: Any, propertyName: String): Boolean {
        var hasPrototype = false
        val fromClzz = obj.javaClass
        val fields = fromClzz.declaredFields
        for (field in fields) {
            if (propertyName == field.name) {
                hasPrototype = true
                break
            }
        }
        return hasPrototype
    }
}