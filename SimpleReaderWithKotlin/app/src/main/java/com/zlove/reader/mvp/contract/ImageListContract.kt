package com.zlove.reader.mvp.contract

import com.zlove.reader.data.ResponseImagesListEntity

/**
 * Created by zlove on 2017/7/19.
 */
class ImageListContract {
    interface View {
        fun refreshListData(imagesListEntity: ResponseImagesListEntity?)
    }

    interface Presenter {
        fun loadListData(keyword: String?, page: Int)
    }
}