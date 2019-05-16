package com.my.retrofitdemo.networkapi

import android.content.Context
import android.util.Log
import com.my.retrofitdemo.R
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * API Base callback
 */
abstract class BaseCallback(private val context: Context) : Callback<ResponseBody> {

    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
        try{
            if(response.body()!=null){
                onSuccess(response.code(), response.body()?.string()!!)
            }else{
                onSuccess(response.code(), "")
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
        try {
            Log.d("Response", call.request().url().toString() + "\n" + t.toString())
        }catch (e: Exception){
            e.printStackTrace()
        }
        val msg:String
        if (t is ConnectException) {
            msg=context.getString(R.string.failed_to_connect_with_server)
            onFailed(0,msg )
        } else if (t is SocketTimeoutException || t is UnknownHostException) {
            msg= context.getString(R.string.failed_to_connect_with_server)
            onFailed(0,msg)
        } else if (t is IOException) {
            msg=context.getString(R.string.something_went_wrong)
            onFailed(0,msg )

        } else {
            msg= t.message!!
            onFailed(0,msg)
        }
    }

    protected abstract fun onSuccess(statusCode: Int, response: String)

    protected abstract fun onFailed(statusCode: Int, message: String)
}