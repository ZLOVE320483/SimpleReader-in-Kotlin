package com.zlove.reader.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.zlove.reader.data.BaseEntity
import com.zlove.reader.ui.frag.ImagesListFragment

/**
 * Created by zlove on 2017/7/19.
 */
class ImagesContainerPagerAdapter(fm: FragmentManager, list: MutableList<BaseEntity>) : FragmentPagerAdapter(fm) {

    var list: MutableList<BaseEntity>? = null

    init {
        this.list = list
    }

    override fun getItem(position: Int): Fragment {
        return ImagesListFragment()
    }

    override fun getCount(): Int {
        return list?.size ?: 0
    }

    override fun getPageTitle(position: Int): CharSequence {
        return list?.get(position)?.name!!
    }
}