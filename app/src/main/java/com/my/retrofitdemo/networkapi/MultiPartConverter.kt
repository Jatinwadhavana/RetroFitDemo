package com.my.retrofitdemo.networkapi


import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit

import java.io.IOException
import java.lang.reflect.Type

class MultiPartConverter : Converter.Factory() {


    override fun responseBodyConverter(
        type: Type?,
        annotations: Array<Annotation>?,
        retrofit: Retrofit?
    ): Converter<ResponseBody, *>? {
        return if (String::class.java == type) {
            Converter<ResponseBody, String> { value -> value.string() }
        } else null
    }

    override fun requestBodyConverter(
        type: Type?,
        parameterAnnotations: Array<Annotation>?,
        methodAnnotations: Array<Annotation>?,
        retrofit: Retrofit?
    ): Converter<*, RequestBody>? {
        return if (String::class.java == type) {
            Converter<String, RequestBody> { value ->
                //                    return RequestBody.create(MediaType.parse("text/plain"), value);
                RequestBody.create(MediaType.parse("multipart/form-data"), value)
            }
        } else null
    }


}