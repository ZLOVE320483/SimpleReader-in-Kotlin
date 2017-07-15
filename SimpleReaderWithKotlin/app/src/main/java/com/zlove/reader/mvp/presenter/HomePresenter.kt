package com.zlove.reader.mvp.presenter

import android.content.Context
import com.zlove.reader.R
import com.zlove.reader.data.NavigateEntity
import com.zlove.reader.mvp.contract.HomeContract

/**
 * Created by zlove on 2017/7/15.
 */
class HomePresenter(context: Context, view: HomeContract.View) : HomeContract.Presenter {

    var mContext: Context? = null
    var mView: HomeContract.View? = null

    init {
        this.mContext = context
        this.mView = view
    }

    override fun start() {
        getNavigateListData()
    }

    override fun getNavigateListData() {
        val navigateNameArrays = mContext?.resources?.getStringArray(R.array.navigation_list)
        val navigateIconResArrays = arrayOf(R.drawable.ic_picture, R.drawable.ic_video, R.drawable.ic_music)
        var navigateList = mutableListOf<NavigateEntity>()

        for (i in 0..navigateNameArrays!!.size - 1) {
            navigateList.add(NavigateEntity("", navigateNameArrays!![i], navigateIconResArrays!![i]))
        }

        mView?.setNavigateListData(navigateList)
    }
}