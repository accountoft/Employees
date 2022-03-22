package com.ekipa2.o7task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ekipa2.o7task.databinding.MainActivityBinding
import com.ekipa2.o7task.ui.main.MainFragment

import androidx.databinding.DataBindingUtil.setContentView
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<MainActivityBinding>(this,R.layout.main_activity)

    }
}