package com.zlove.reader.widget

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by zlove on 2017/7/15.
 */

class XViewPager : ViewPager {

    var isEnableScroll: Boolean? = true

    fun setEnableScroll(isEnableScroll: Boolean) {
        this.isEnableScroll = isEnableScroll
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        if (!isEnableScroll!!) {
            return false
        }
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        if (!isEnableScroll!!) {
            return false
        }
        return super.onTouchEvent(ev)
    }
}
