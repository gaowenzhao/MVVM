package com.zhao.base.utils

object CopyBeanUtils {
     val TAG = CopyBeanUtils::class.java.simpleName
    fun copy(fromObject:Any,toObject:Any):Any{
        var fromClzz = fromObject.javaClass
        var toClzz = toObject.javaClass
        val toFieds = toClzz.declaredFields
        for (toField in toFieds){
             val fromField = fromClzz.getDeclaredField(toField.name)
             fromField.isAccessible = true
             val value = fromField.get(fromObject)
             if(fromField!=null){
                 toField.isAccessible = true
                 toField.set(toObject,value)
            }
        }
        return toObject
    }
}