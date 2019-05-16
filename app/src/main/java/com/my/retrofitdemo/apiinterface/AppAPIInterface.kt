package com.my.retrofitdemo.apiinterface

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface AppAPIInterface {

    @GET("/api/v1/colors/-/{id}")
    fun callGetShades(@Path("id") req: String): Call<ResponseBody>

    @GET("/api/v1/colors/-")
    fun callGetColor(): Call<ResponseBody>

    @POST("/api/v1/users/-")
    @FormUrlEncoded
    fun callAddContactUS(@FieldMap req: HashMap<String, String>): Call<ResponseBody>

    @POST("/api/v1/users/-")
    @FormUrlEncoded
    fun callAddServiceType(@FieldMap req: HashMap<String, String>): Call<ResponseBody>

    @POST("/api/v1/users/-")
    @FormUrlEncoded
    fun callAddCustomerDetails(@FieldMap req: HashMap<String, String>): Call<ResponseBody>
}