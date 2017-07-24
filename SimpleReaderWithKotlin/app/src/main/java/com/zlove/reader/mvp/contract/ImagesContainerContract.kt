package com.zlove.reader.mvp.contract

import com.zlove.reader.data.BaseEntity
import com.zlove.reader.mvp.base.BasePresenter
import com.zlove.reader.mvp.base.BaseView

/**
 * Created by zlove on 2017/7/22.
 */
class ImagesContainerContract {

    interface View : BaseView {
        fun setFragmentData(list: MutableList<BaseEntity>)
    }

    interface Presenter : BasePresenter {
        fun getImagesListCategory()
    }
}