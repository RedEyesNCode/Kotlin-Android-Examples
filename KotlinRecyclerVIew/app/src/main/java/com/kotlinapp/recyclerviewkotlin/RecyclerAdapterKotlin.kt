package com.kotlinapp.recyclerviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinapp.recyclerviewkotlin.databinding.CardViewDesignBinding

//Taking the var of Type Interface and Intializing it in the Activity
class RecyclerAdapterKotlin(private var list: List<RecyclerListModel>, private var onItemclick: onItemClick,private var context:Context) : RecyclerView.Adapter<RecyclerAdapterKotlin.MyViewHolder>() {
    lateinit var  listBinding :CardViewDesignBinding


    //View Binding in Adapter.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        listBinding = CardViewDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MyViewHolder(listBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder){
            with(list.get(position)){
                listBinding.textView.text = this.itemName
            }
        }
        listBinding.textView.setOnClickListener {
            onItemclick.onClicked(position)
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    //extending the viewHolder Class of Recycler View and Passing the List Binding in Constructor
    //Then Binding.getRoot() in the ViewHolderParamter
    class MyViewHolder(binding: CardViewDesignBinding) : RecyclerView.ViewHolder(binding.root){
    }

    //This Interface is Written in order to Write the OverRide the CLicked Funtion of Adapter in the Activity
    interface onItemClick{
        fun onClicked(int: Int)
    }


}