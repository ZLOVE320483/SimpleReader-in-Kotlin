package com.zlove.reader.ui.frag

import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.zlove.reader.R
import com.zlove.reader.data.ResponseImagesListEntity
import com.zlove.reader.mvp.contract.ImageListContract
import com.zlove.reader.mvp.presenter.ImageListPresenter
import com.zlove.reader.ui.adapter.ImageListAdapter
import kotlinx.android.synthetic.main.fragment_images_list.*

/**
 * Created by zlove on 2017/7/19.
 */
class ImagesListFragment : BaseFragment(), ImageListContract.View {

    var mPresenter: ImageListPresenter? = null
    var mAdapter: ImageListAdapter? = null

    companion object {
        var mCurrentImagesCategory: String? = null
    }

    var mCurrentPage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mCurrentImagesCategory = resources?.getStringArray(R.array.images_category_list_id)!![0]
    }

    override fun getContentViewLayoutID(): Int {
        return R.layout.fragment_images_list
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onFirstUserVisible() {
        mCurrentPage = 0
        mPresenter = ImageListPresenter(mContext!!, this)

        fragment_images_list_list_view.postDelayed({
            mPresenter?.loadListData(mCurrentImagesCategory, mCurrentPage)
        }, 200)

    }

    override fun onUserVisible() {

    }

    override fun onFirstUserInVisible() {

    }

    override fun onUserInVisible() {

    }

    override fun refreshListData(imagesListEntity: ResponseImagesListEntity?) {
        mAdapter = ImageListAdapter(context, imagesListEntity?.imgs)
        fragment_images_list_list_view.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        fragment_images_list_list_view.adapter = mAdapter
    }

    fun onPageSelected(keywords: String) {
        mCurrentImagesCategory = keywords
    }
}