package com.my.retrofitdemo.apiinterface

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface FileUploadService {

    @POST("/api/v1/user/edit")
    @Multipart
    fun singleFileUpload(@Part fileBody: MultipartBody.Part, @PartMap req: Map<String, String>, @Header("Authorization") header: String):Call<String>


    @Multipart
    @POST("/api/v1/-")
    fun postMultiFiles(@Part Files: List<MultipartBody.Part>, @PartMap req: Map<String, String>, @Header("Authorization") header: String): Call<String>
}