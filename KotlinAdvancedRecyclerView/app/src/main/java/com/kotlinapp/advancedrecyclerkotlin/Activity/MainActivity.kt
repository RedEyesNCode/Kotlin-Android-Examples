package com.kotlinapp.advancedrecyclerkotlin.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlinapp.advancedrecyclerkotlin.Adapters.AdvancedAdapter
import com.kotlinapp.advancedrecyclerkotlin.Model.RecyclerListData
import com.kotlinapp.advancedrecyclerkotlin.R
import com.kotlinapp.advancedrecyclerkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdvancedAdapter.onClicked {
    lateinit var binding:ActivityMainBinding
    override fun onItemClicked(int: Int) {
        var intent = Intent(this,ClickedActivity::class.java)
        Toast.makeText(this,"You Clicked on $int number ",Toast.LENGTH_LONG).show()
        startActivity(intent)



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dataList = mutableListOf<RecyclerListData>()
        for(i in 1..10){
            dataList.add(RecyclerListData("Ashu",i))
        }
        binding.recyclerview.adapter = AdvancedAdapter(dataList,this,this)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)


    }
}