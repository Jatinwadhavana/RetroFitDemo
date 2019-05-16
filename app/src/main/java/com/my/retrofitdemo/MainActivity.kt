package com.my.retrofitdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.my.retrofitdemo.apiinterface.AppAPIInterface
import com.my.retrofitdemo.networkapi.BaseCallback
import com.my.retrofitdemo.networkapi.RetrofitInstance
import org.json.JSONObject
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val req = HashMap<String,String>()
        RetrofitInstance.getInstance().with().create(AppAPIInterface::class.java).callAddContactUS(req)
            .enqueue(object : BaseCallback(this) {
                override fun onSuccess(statusCode: Int, response: String) {
                }

                override fun onFailed(statusCode: Int, message: String) {
                }
            })
    }
}
