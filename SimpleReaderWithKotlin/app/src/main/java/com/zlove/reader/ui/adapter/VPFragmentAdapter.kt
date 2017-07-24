package com.zlove.reader.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.zlove.reader.ui.frag.BaseFragment

/**
 * Created by zlove on 2017/7/22.
 */
class VPFragmentAdapter(fm: FragmentManager, list: MutableList<BaseFragment>) : FragmentPagerAdapter(fm) {

    var list: MutableList<BaseFragment>? = null

    init {
        this.list = list
    }

    override fun getItem(position: Int): Fragment {
        return list?.get(position)!!
    }

    override fun getCount(): Int {
        return list?.size ?: 0
    }
}