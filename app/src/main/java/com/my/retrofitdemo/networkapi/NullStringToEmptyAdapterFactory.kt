package com.my.retrofitdemo.networkapi

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken

class NullStringToEmptyAdapterFactory<T> : TypeAdapterFactory {
    override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {

        val rawType = type.rawType as Class<T>
        return if (rawType != String::class.java) {
            null
        } else StringAdapter() as TypeAdapter<T>
    }
}