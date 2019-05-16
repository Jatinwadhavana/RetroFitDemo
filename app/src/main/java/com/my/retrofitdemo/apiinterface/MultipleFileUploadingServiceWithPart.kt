package com.my.retrofitdemo.apiinterface

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

/**
 * Multiple files uploading.
 */
interface MultipleFileUploadingServiceWithPart {
    @Multipart
    @POST("/api/v1/createTask")
    fun postMultiFiles(@Part Files: List<MultipartBody.Part>, @PartMap req: Map<String, String>, @Header("Authorization") header: String): Call<String>
}