package com.my.retrofitdemo.apiinterface

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface FileUploadService {
    @POST("/api/v1/users/document-uploading")
    @Multipart
    fun callDocumentUploading(@Part fileBody: MultipartBody.Part, @PartMap req: Map<String, String>, @Header("Authorization") header: String): Call<String>
}