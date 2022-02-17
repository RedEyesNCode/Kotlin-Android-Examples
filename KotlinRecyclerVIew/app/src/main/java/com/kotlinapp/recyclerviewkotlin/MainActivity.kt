package com.kotlinapp.recyclerviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlinapp.recyclerviewkotlin.databinding.ActivityMainBinding


//ExtendingTwo things AppCompatActivity by Default and Adapter Interface for the Click function.
class MainActivity : AppCompatActivity() , RecyclerAdapterKotlin.onItemClick {
    //ViewBinding in Activity



    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //Creating the Dummy Data for the Recycler View.
        var dataList = mutableListOf<RecyclerListModel>()
        for(i in 1..10){
            dataList.add(RecyclerListModel(1,"ITEM : "+i))
        }

        val recyclerView  :RecyclerView
        //Setting the Adapter and The Layout Manager for the recycler View
        binding.recyclerview.adapter = RecyclerAdapterKotlin(dataList,this,this)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)




    }

    override fun onClicked(int: Int) {
        Toast.makeText(this,"Clicked",Toast.LENGTH_LONG).show()
    }
}