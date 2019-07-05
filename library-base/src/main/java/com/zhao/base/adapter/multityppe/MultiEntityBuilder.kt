package com.hzcfapp.qmwallet.widget.recycler
import com.zhao.base.adapter.multityppe.MultiEntityBuilderI
import com.zhao.base.adapter.multityppe.MultiItemEntity

/**
 * 高文钊
 */
class MultiEntityBuilder : MultiEntityBuilderI {
    private var entityMap:HashMap<Any,Any> = HashMap<Any,Any>()
    init {
        entityMap.clear()
    }
    fun setField(key:Any,value:Any):MultiEntityBuilder{
        entityMap[key] = value
        return this
    }
    override fun setSpanSize(value:Int):MultiEntityBuilder{
        entityMap[MultipleFields.SPAN_SIZE] = value
        return this
    }
    override fun setVhType(value:Int):MultiEntityBuilder{
        entityMap[MultipleFields.ITEM_TYPE] = value
        return this
    }
    override fun setContent(value:Any):MultiEntityBuilder{
        entityMap[MultipleFields.CONTENT] = value
        return this
    }
    fun build(): MultiItemEntity {
        return MultiItemEntity(entityMap)
    }
}