package com.zlove.reader

import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.zlove.reader.data.NavigateEntity
import com.zlove.reader.mvp.contract.HomeContract
import com.zlove.reader.mvp.presenter.HomePresenter
import com.zlove.reader.ui.activity.BaseActivity
import com.zlove.reader.ui.adapter.HomeNavigateListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.common_toolbar.*

class MainActivity : BaseActivity(), HomeContract.View {

    var mActionBarDrawerToggle: ActionBarDrawerToggle? = null
    var mAdapter: HomeNavigateListAdapter? = null
    var mPresenter: HomePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        common_toolbar.title = getString(R.string.app_name)
        mActionBarDrawerToggle = object : ActionBarDrawerToggle(this, home_drawer, common_toolbar, R.string.drawer_open, R.string.drawer_close) {

            override fun onDrawerOpened(drawerView: View?) {
                super.onDrawerOpened(drawerView)
                common_toolbar.title = getString(R.string.app_name)
            }

            override fun onDrawerClosed(drawerView: View?) {
                super.onDrawerClosed(drawerView)
            }
        }
        mActionBarDrawerToggle?.isDrawerIndicatorEnabled = true
        home_drawer.setDrawerListener(mActionBarDrawerToggle)
    }

    override fun initData() {
        mPresenter = HomePresenter(this, this)
        mPresenter?.start()
    }

    override fun setNavigateListData(list: MutableList<NavigateEntity>) {
        home_navigation_list.layoutManager = LinearLayoutManager(this)
        mAdapter = HomeNavigateListAdapter(this, list)
        home_navigation_list?.adapter = mAdapter
    }
}
