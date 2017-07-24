package com.zlove.reader.mvp.contract

import com.zlove.reader.data.NavigateEntity
import com.zlove.reader.mvp.base.BasePresenter
import com.zlove.reader.mvp.base.BaseView
import com.zlove.reader.ui.frag.BaseFragment

/**
 * Created by zlove on 2017/7/15.
 */
class HomeContract {
    interface View : BaseView {
        fun setNavigateListData(list: MutableList<NavigateEntity>, fragments: MutableList<BaseFragment>)
    }

    interface Presenter : BasePresenter {
        fun getNavigateListData()
    }
}