package com.kotlinapp.advancedrecyclerkotlin.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinapp.advancedrecyclerkotlin.Model.RecyclerListData
import com.kotlinapp.advancedrecyclerkotlin.databinding.CardViewDesignBinding

class AdvancedAdapter(private var list:List<RecyclerListData>, private var onClick: onClicked, private var context:Context) : RecyclerView.Adapter<AdvancedAdapter.MyViewHolder>() {
    lateinit var binding : CardViewDesignBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        binding = CardViewDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder){
            with(list.get(position)){
                binding.textView.text = this.name

            }

        }
        binding.textView.setOnClickListener {
            onClick.onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {

        return list.size
    }

    inner class MyViewHolder(binding: CardViewDesignBinding) : RecyclerView.ViewHolder(binding.root){

    }

    interface onClicked{
        fun onItemClicked(int :Int)
    }

}