package com.zlove.reader.mvp.presenter

import android.content.Context
import com.zlove.reader.R
import com.zlove.reader.data.BaseEntity
import com.zlove.reader.mvp.contract.ImagesContainerContract

/**
 * Created by zlove on 2017/7/22.
 */
class ImagesContainerPresenter(context: Context, view: ImagesContainerContract.View) : ImagesContainerContract.Presenter {

    var mContext: Context? = null
    var mView: ImagesContainerContract.View? = null

    init {
        mContext = context
        mView = view
    }

    override fun start() {
        getImagesListCategory()
    }

    override fun getImagesListCategory() {
        val imagesCategoryArrayId = mContext?.resources?.getStringArray(R.array.images_category_list_id)
        val imagesCategoryArrayName = mContext?.resources?.getStringArray(R.array.images_category_list_name)
        var categoryList = mutableListOf<BaseEntity>()

        for (i in 0..imagesCategoryArrayId!!.size - 1) {
            categoryList.add(BaseEntity(imagesCategoryArrayId!![i], imagesCategoryArrayName!![i]))
        }
        mView?.setFragmentData(categoryList)
    }
}