package com.zlove.reader.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.zlove.reader.R
import com.zlove.reader.data.NavigateEntity

/**
 * Created by zlove on 2017/7/15.
 */
class HomeNavigateListAdapter(context: Context, list: MutableList<NavigateEntity>?, listener: OnItemClickListener) : RecyclerView.Adapter<HomeNavigateListAdapter.NavigateViewHolder>() {

    var mContext: Context? = null
    var list: MutableList<NavigateEntity>? = null
    var mInflate: LayoutInflater? = null
    var mListener: OnItemClickListener? = null

    init {
        this.mContext = context
        this.list = list
        this.mInflate = LayoutInflater.from(mContext)
        this.mListener = listener
    }


    override fun getItemCount(): Int {
        return list?.size ?:0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NavigateViewHolder {
        return NavigateViewHolder(mInflate?.inflate(R.layout.list_item_navigation, parent, false))
    }

    override fun onBindViewHolder(holder: NavigateViewHolder?, position: Int) {
        var entity = list?.get(position)
        holder?.itemIcon?.setImageResource(entity?.iconResId!!)
        holder?.itemName?.text = entity?.name
        holder?.itemView?.setOnClickListener {
            mListener?.onItemClick(position)
        }
    }

    class NavigateViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var itemIcon: ImageView? = null
        var itemName: TextView? = null

        init {
            itemIcon = itemView?.findViewById(R.id.list_item_navigation_icon) as ImageView
            itemName = itemView?.findViewById(R.id.list_item_navigation_name) as TextView
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}