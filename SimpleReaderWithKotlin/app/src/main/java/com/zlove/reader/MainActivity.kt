package com.zlove.reader

import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import com.zlove.reader.data.NavigateEntity
import com.zlove.reader.mvp.contract.HomeContract
import com.zlove.reader.mvp.presenter.HomePresenter
import com.zlove.reader.ui.activity.BaseActivity
import com.zlove.reader.ui.adapter.HomeNavigateListAdapter
import com.zlove.reader.ui.adapter.VPFragmentAdapter
import com.zlove.reader.ui.frag.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.common_toolbar.*

class MainActivity : BaseActivity(), HomeContract.View, HomeNavigateListAdapter.OnItemClickListener {

    var mActionBarDrawerToggle: ActionBarDrawerToggle? = null
    var mAdapter: HomeNavigateListAdapter? = null
    var mPresenter: HomePresenter? = null
    var currentPos: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        mActionBarDrawerToggle = object : ActionBarDrawerToggle(this, home_drawer, common_toolbar, R.string.drawer_open, R.string.drawer_close) {

            override fun onDrawerOpened(drawerView: View?) {
                super.onDrawerOpened(drawerView)
                common_toolbar.title = getString(R.string.app_name)
            }

            override fun onDrawerClosed(drawerView: View?) {
                super.onDrawerClosed(drawerView)
                common_toolbar.title = mAdapter?.list?.get(currentPos!!)?.name
            }
        }
        mActionBarDrawerToggle?.isDrawerIndicatorEnabled = true
        home_drawer.setDrawerListener(mActionBarDrawerToggle)
    }

    override fun initData() {
        mPresenter = HomePresenter(this, this)
        mPresenter?.start()
    }

    override fun setNavigateListData(list: MutableList<NavigateEntity>, fragments: MutableList<BaseFragment>) {
        home_navigation_list.layoutManager = LinearLayoutManager(this)
        mAdapter = HomeNavigateListAdapter(this, list, this)
        home_navigation_list?.adapter = mAdapter

        common_toolbar.title = mAdapter?.list?.get(currentPos!!)?.name
        home_container.setEnableScroll(false)
        home_container.offscreenPageLimit = fragments.size
        home_container.adapter = VPFragmentAdapter(supportFragmentManager, fragments)
    }

    override fun onItemClick(position: Int) {
        this.currentPos = position
        home_drawer.closeDrawer(Gravity.LEFT)
    }
}
