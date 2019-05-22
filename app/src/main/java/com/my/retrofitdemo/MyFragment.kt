package com.my.retrofitdemo

import android.os.Bundle
import android.support.v4.app.Fragment

class MyFragment : Fragment() {
    init {
        val b = Fragment() as MyFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}