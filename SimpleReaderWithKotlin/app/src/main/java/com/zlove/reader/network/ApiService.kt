package com.zlove.reader.network

import com.zlove.reader.data.ResponseImagesListEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by zlove on 2017/7/19.
 */
interface ApiService {
    companion object {
        val IMAGE_BASE_URL: String
            get() = "http://image.baidu.com"
    }

    @GET("/data/imgs")
    fun getImageListData(@Query("col") keyword: String?,
                         @Query("tag") tag: String?,
                         @Query("pn") pn: Int,
                         @Query("rn") rn: Int,
                         @Query("from") from: Int): Observable<ResponseImagesListEntity>

}