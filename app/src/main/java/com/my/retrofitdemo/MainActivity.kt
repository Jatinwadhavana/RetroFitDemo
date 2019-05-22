package com.my.retrofitdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.my.retrofitdemo.apiinterface.FileUploadService
import com.my.retrofitdemo.networkapi.RetrofitInstance
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val req = HashMap<String,String>()
        RetrofitInstance.getInstance().with().create(AppAPIInterface::class.java).callAddContactUS(req)
            .enqueue(object : BaseCallback(this) {
                override fun onSuccess(statusCode: Int, response: String) {
                }

                override fun onFailed(statusCode: Int, message: String) {
                }
            })*/

        //For single file upload
        val requestBody = okhttp3.RequestBody.create(okhttp3.MediaType.parse("multipart/form-data"), "file")
        val body = MultipartBody.Part.createFormData("key", "file.getName()", requestBody)

        val singleReqMap=HashMap<String, String>()
        RetrofitInstance.getInstance().withSingleImage().create(FileUploadService::class.java).singleFileUpload(body,singleReqMap,"")

        //For multi file upload
        val listOfPart = ArrayList<MultipartBody.Part>()
        val filePathArray = ArrayList<String>()

        for (singleFilePath in filePathArray) {
            val singleFile = File(singleFilePath)
            val requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), singleFile)
            listOfPart.add(MultipartBody.Part.createFormData("PICTURES_KEY", singleFile.name, requestBody))
        }
        val reqMulti=HashMap<String, String>()
        RetrofitInstance.getInstance().withMultiImage().create(FileUploadService::class.java).postMultiFiles(listOfPart,reqMulti,"")
    }
}