package com.zlove.reader.mvp.model

import com.zlove.eyepetizer.network.RetrofitClient
import com.zlove.reader.data.ResponseImagesListEntity
import com.zlove.reader.network.ApiService
import io.reactivex.Observable

/**
 * Created by zlove on 2017/7/19.
 */
class ImageListModel {

    fun loadImageListData(keyword: String?, page: Int) : Observable<ResponseImagesListEntity>? {
        val retrofitClient = RetrofitClient.getInstance(ApiService.IMAGE_BASE_URL)
        val apiService  = retrofitClient.create(ApiService::class.java)
        return apiService?.getImageListData(keyword, "全部", page, 20 , 1)
    }
}