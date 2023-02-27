package com.example.productcontaner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.productcontaner.databinding.ActivityMainBinding
import com.example.productcontaner.viewmodel.ListViewModel
import com.example.productcontaner.viewmodel.ListViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myViewModel : ListViewModel
    private lateinit var myadapter: baseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        setContentView(binding.root)
        setupInstances()
        myViewModel.myResponse.observe(this, Observer {
            Log.d("qwerty", it.body().toString())
            myadapter = baseAdapter(it.body()!!)
            binding.myrecyclerview.adapter=myadapter
        })
    }
    private fun setupInstances(){
        myViewModel = ViewModelProvider(this , ListViewModelFactory())[ListViewModel::class.java]
        myViewModel.getCall()
        myrecyclerview.layoutManager = LinearLayoutManager(this)
        binding.myrecyclerview.setHasFixedSize(true)
    }

}