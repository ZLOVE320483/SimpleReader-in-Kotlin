package com.zlove.reader.mvp.contract

import com.zlove.reader.data.NavigateEntity
import com.zlove.reader.mvp.base.BasePresenter
import com.zlove.reader.mvp.base.BaseView

/**
 * Created by zlove on 2017/7/15.
 */
class HomeContract {
    interface View : BaseView {
        fun setNavigateListData(list: MutableList<NavigateEntity>)
    }

    interface Presenter : BasePresenter {
        fun getNavigateListData()
    }
}