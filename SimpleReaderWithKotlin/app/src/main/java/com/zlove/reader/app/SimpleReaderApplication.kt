package com.zlove.reader.app

import android.app.Application
import android.content.Context

/**
 * Created by zlove on 2017/7/14.
 */

class SimpleReaderApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: SimpleReaderApplication? = null

        fun getApplicationContext() : Context {
            return instance!!
        }
    }
}
