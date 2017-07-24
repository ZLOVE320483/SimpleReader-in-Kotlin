package com.zlove.reader.ui.frag

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by zlove on 2017/7/18.
 */
abstract class BaseFragment : Fragment() {

    var isFirstVisible: Boolean = true
    var isFirstInVisible: Boolean = true
    private var isPrepared: Boolean = false

    var mContext: Context? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (getContentViewLayoutID() > 0) {
            return inflater?.inflate(getContentViewLayoutID(), null)
        } else {
            return super.onCreateView(inflater, container, savedInstanceState)
        }
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        mContext = activity
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initPrepare()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            if (isFirstVisible) {
                isFirstVisible = false
                initPrepare()
            } else {
                onUserVisible()
            }
        } else {
            if (isFirstInVisible) {
                isFirstInVisible = false
                onFirstUserInVisible()
            } else {
                onUserInVisible()
            }
        }
    }

    @Synchronized private fun initPrepare() {
        if (isPrepared) {
            onFirstUserVisible()
        } else {
            isPrepared = true
        }
    }

    abstract fun getContentViewLayoutID(): Int

    abstract fun onFirstUserVisible()

    abstract fun onUserVisible()

    abstract fun onFirstUserInVisible()

    abstract fun onUserInVisible()
}