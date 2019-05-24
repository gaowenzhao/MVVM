package com.zhao.home.view

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator

class HolderCreator: CBViewHolderCreator<ImageHolder> {
    override fun createHolder(): ImageHolder {
        return ImageHolder()
    }
}