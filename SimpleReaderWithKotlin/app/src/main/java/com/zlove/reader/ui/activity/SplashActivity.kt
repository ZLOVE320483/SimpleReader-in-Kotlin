package com.zlove.reader.ui.activity

import android.graphics.Typeface
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.zlove.eyepetizer.utils.newIntent
import com.zlove.reader.MainActivity
import com.zlove.reader.R
import com.zlove.reader.mvp.contract.SplashContract
import com.zlove.reader.mvp.presenter.SplashPresenter
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*

class SplashActivity : BaseActivity(), SplashContract.View {

    var mPresenter: SplashPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_splash
    }

    override fun initView() {
    }

    override fun initData() {
        mPresenter = SplashPresenter(this)
        mPresenter?.start()
    }

    override fun changeTextFont() {
        val font : Typeface = Typeface.createFromAsset(this.assets, "fonts/Lobster-1.4.otf")
        splash_app_name.typeface = font
    }

    override fun setAnimation() {
        var resId: Int
        var calender: Calendar? = Calendar.getInstance()
        val hour: Int = calender!!.get(Calendar.HOUR_OF_DAY)

        when(hour) {
            in 6..12 -> resId = R.drawable.morning
            in 12..18 -> resId = R.drawable.afternoon
            else -> resId = R.drawable.night
        }
        splash_image.setImageResource(resId)
        var animation: Animation? = AnimationUtils.loadAnimation(this, R.anim.splash)
        animation?.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                newIntent<MainActivity>()
                finish()
            }

            override fun onAnimationStart(animation: Animation?) {
            }
        })
        splash_image.startAnimation(animation)
    }
}
