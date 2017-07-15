package com.zlove.reader.mvp.contract

import com.zlove.reader.mvp.base.BasePresenter
import com.zlove.reader.mvp.base.BaseView

/**
 * Created by zlove on 2017/7/15.
 */
class SplashContract {
    interface View : BaseView {
        fun changeTextFont()
        fun setAnimation()
    }

    interface Presenter : BasePresenter {
        fun startAnimation()
    }
}