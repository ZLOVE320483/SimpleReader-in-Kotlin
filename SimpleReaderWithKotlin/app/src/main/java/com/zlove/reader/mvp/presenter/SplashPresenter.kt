package com.zlove.reader.mvp.presenter

import com.zlove.reader.mvp.contract.SplashContract

/**
 * Created by zlove on 2017/7/15.
 */
class SplashPresenter(view: SplashContract.View) : SplashContract.Presenter {

    var mView: SplashContract.View? = null

    init {
        mView = view
    }

    override fun start() {
        mView?.changeTextFont()
        startAnimation()
    }

    override fun startAnimation() {
        mView?.setAnimation()
    }
}