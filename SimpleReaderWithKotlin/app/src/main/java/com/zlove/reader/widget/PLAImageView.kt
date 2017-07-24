/*
 * Copyright (c) 2015 [1076559197@qq.com | tchen0707@gmail.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zlove.reader.widget

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout

/**
 * This view will auto determine the width or height by determining if the
 * height or width is set and scale the other dimension depending on the images
 * dimension
 *
 *
 * This view also contains an ImageChangeListener which calls changed(boolean
 * isEmpty) once a change has been made to the ImageView

 * @author Maurycy Wojtowicz
 */
class PLAImageView : ImageView {
    private var currentBitmap: Bitmap? = null
    var imageChangeListener: ImageChangeListener? = null
    private var scaleToWidth = false // this flag determines if should
    // measure height manually dependent
    // of width

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    private fun init() {
        this.scaleType = ImageView.ScaleType.CENTER_INSIDE
    }

    fun recycle() {
        setImageBitmap(null)
        if (this.currentBitmap == null || this.currentBitmap!!.isRecycled)
            return
        this.currentBitmap!!.recycle()
        this.currentBitmap = null
    }

    override fun setImageBitmap(bm: Bitmap?) {
        currentBitmap = bm
        super.setImageBitmap(currentBitmap)
        if (imageChangeListener != null)
            imageChangeListener!!.changed(currentBitmap == null)
    }

    override fun setImageDrawable(d: Drawable?) {
        super.setImageDrawable(d)
        if (imageChangeListener != null)
            imageChangeListener!!.changed(d == null)
    }

    override fun setImageResource(id: Int) {
        super.setImageResource(id)
    }

    interface ImageChangeListener {
        // a callback for when a change has been made to this imageView
        fun changed(isEmpty: Boolean)
    }

    private var imageWidth: Int = 0
    private var imageHeight: Int = 0

    fun setImageWidth(w: Int) {
        imageWidth = w
    }

    fun setImageHeight(h: Int) {
        imageHeight = h
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        var width = MeasureSpec.getSize(widthMeasureSpec)
        var height = MeasureSpec.getSize(heightMeasureSpec)

        /**
         * if both width and height are set scale width first. modify in future
         * if necessary
         */

        if (widthMode == View.MeasureSpec.EXACTLY || widthMode == View.MeasureSpec.AT_MOST) {
            scaleToWidth = true
        } else if (heightMode == View.MeasureSpec.EXACTLY || heightMode == View.MeasureSpec.AT_MOST) {
            scaleToWidth = false
        } else
            throw IllegalStateException("width or height needs to be set to match_parent or a specific dimension")

        if (imageWidth == 0) {
            // nothing to measure
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            return
        } else {
            if (scaleToWidth) {
                val iw = imageWidth
                val ih = imageHeight
                var heightC = width * ih / iw
                if (height > 0)
                    if (heightC > height) {
                        // dont let hegiht be greater then set max
                        heightC = height
                        width = heightC * iw / ih
                    }

                this.scaleType = ImageView.ScaleType.CENTER_CROP
                setMeasuredDimension(width, heightC)

            } else {
                // need to scale to height instead
                var marg = 0
                if (parent != null) {
                    if (parent.parent != null) {
                        marg += (parent.parent as RelativeLayout).paddingTop
                        marg += (parent.parent as RelativeLayout).paddingBottom
                    }
                }

                val iw = imageWidth
                val ih = imageHeight

                width = height * iw / ih
                height -= marg
                setMeasuredDimension(width, height)
            }

        }
    }

}
