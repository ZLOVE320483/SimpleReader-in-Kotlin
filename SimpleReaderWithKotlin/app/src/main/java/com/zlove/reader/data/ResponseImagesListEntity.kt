package com.zlove.reader.data

/**
 * Created by zlove on 2017/7/19.
 */
data class ResponseImagesListEntity(var col: String?, var tag: String?, var tag3: String?,
                                    var sort: String?, var totalNum: Int, var startIndex: Int,
                                    var returnNumber: Int, var imgs: MutableList<ImagesListEntity>?) {
    data class ImagesListEntity(var id: String?, var desc: String?, var tags: MutableList<String>?,
                                var fromPageTitle: String?, var column: String?, var date: String?,
                                var downloadUrl: String?, var imageUrl: String?, var imageWidth: Int,
                                var imageHeight: Int, var thumbnailUrl: String?, var thumbnailWidth: Int,
                                var thumbnailHeight: Int, var thumbnailLargeUrl: String?, var thumbnailLargeWidth: Int,
                                var thumbnailLargeHeight: Int, var thumbnailLargeTnUrl: String?, var thumbnailLargeTnWidth: Int,
                                var thumbnailLargeTnHeight: Int, var siteName: String?, var siteLogo: String?,
                                var siteUrl: String?, var fromUrl: String?, var objUrl: String?,
                                var shareUrl: String?, var albumId: String?, var isAlbum: Int,
                                var albumName: String?, var albumNum: Int, var title: String?) {
    }
}