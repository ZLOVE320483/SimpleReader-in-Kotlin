package com.zlove.reader.mvp.presenter

import android.content.Context
import com.zlove.eyepetizer.utils.applySchedulers
import com.zlove.reader.data.ResponseImagesListEntity
import com.zlove.reader.mvp.contract.ImageListContract
import com.zlove.reader.mvp.model.ImageListModel
import io.reactivex.Observable

/**
 * Created by zlove on 2017/7/19.
 */
class ImageListPresenter(context: Context, view: ImageListContract.View) : ImageListContract.Presenter {

    var mContext: Context? = null
    var mView: ImageListContract.View? = null
    val mModel: ImageListModel by lazy { ImageListModel() }

    init {
        this.mContext = context
        this.mView = view
    }


    override fun loadListData(keyword: String?, page: Int) {
        val observable: Observable<ResponseImagesListEntity>? = mContext.let { mModel.loadImageListData(keyword, page) }
        observable?.applySchedulers()?.subscribe { entity: ResponseImagesListEntity -> mView?.refreshListData(entity) }
    }
}