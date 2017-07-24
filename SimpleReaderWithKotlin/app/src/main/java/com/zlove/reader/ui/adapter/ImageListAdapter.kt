package com.zlove.reader.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zlove.eyepetizer.utils.ImageLoadUtils
import com.zlove.reader.R
import com.zlove.reader.data.ResponseImagesListEntity
import com.zlove.reader.widget.PLAImageView

/**
 * Created by zlove on 2017/7/19.
 */
class ImageListAdapter(context: Context, list: MutableList<ResponseImagesListEntity.ImagesListEntity>?) : RecyclerView.Adapter<ImageListAdapter.ImageViewHolder>() {


    var mContext: Context? = null
    var list: MutableList<ResponseImagesListEntity.ImagesListEntity>? = null
    var mInflate: LayoutInflater? = null

    init {
        this.mContext = context
        this.list = list
        this.mInflate = LayoutInflater.from(mContext)
    }

    override fun getItemCount(): Int {
        return list?.size ?:0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ImageViewHolder {
        return ImageViewHolder(mInflate?.inflate(R.layout.list_item_images_list, parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder?, position: Int) {
        var entity = list?.get(position)
        if (entity != null && !TextUtils.isEmpty(entity?.thumbnailUrl)) {
            ImageLoadUtils.display(mContext!!, holder?.image!!, entity?.thumbnailUrl!!)
            holder?.image!!.setImageWidth(entity?.thumbnailWidth)
            holder?.image!!.setImageHeight(entity?.thumbnailHeight)
        }

    }

    class ImageViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var image: PLAImageView? = null

        init {
            image = itemView?.findViewById(R.id.list_item_images_list_image) as PLAImageView
        }
    }
}