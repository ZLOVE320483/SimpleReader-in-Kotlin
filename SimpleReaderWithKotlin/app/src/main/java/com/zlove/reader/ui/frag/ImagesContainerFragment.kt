package com.zlove.reader.ui.frag

import android.support.v4.view.ViewPager
import com.zlove.reader.R
import com.zlove.reader.data.BaseEntity
import com.zlove.reader.mvp.contract.ImagesContainerContract
import com.zlove.reader.mvp.presenter.ImagesContainerPresenter
import com.zlove.reader.ui.adapter.ImagesContainerPagerAdapter
import kotlinx.android.synthetic.main.fragment_images.*

/**
 * Created by zlove on 2017/7/18.
 */
class ImagesContainerFragment : BaseFragment(), ImagesContainerContract.View {

    var mPresenter: ImagesContainerPresenter? = null

    override fun getContentViewLayoutID(): Int {
        return R.layout.fragment_images
    }

    override fun onFirstUserVisible() {
        mPresenter = ImagesContainerPresenter(mContext!!, this)
        mPresenter?.start()
    }

    override fun onUserVisible() {
    }

    override fun onFirstUserInVisible() {
    }

    override fun onUserInVisible() {
    }

    override fun setFragmentData(list: MutableList<BaseEntity>) {
        if (list.size > 0) {
            fragment_images_pager.offscreenPageLimit = list.size
            fragment_images_pager.adapter = ImagesContainerPagerAdapter(activity.supportFragmentManager, list)
            fragment_images_tab_smart.setViewPager(fragment_images_pager)
            fragment_images_tab_smart.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                }

                override fun onPageSelected(position: Int) {
                    val fragment = fragment_images_pager.adapter.instantiateItem(fragment_images_pager, position) as ImagesListFragment
                    fragment.onPageSelected(list[position].id!!)
                }

                override fun onPageScrollStateChanged(state: Int) {

                }
            })
        }
    }
}