package com.zlove.reader.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getLayoutResourceId() != 0) {
            setContentView(getLayoutResourceId())
        }
        initView()
        initData()
    }

    abstract fun initView()
    abstract fun initData()
    abstract fun getLayoutResourceId() : Int
}
