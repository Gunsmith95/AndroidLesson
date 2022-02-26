package com.example.mylearningandriod

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylearningandriod.databinding.IAmItemBinding

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    val myList = ArrayList<Plant>()

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {

        val binding = IAmItemBinding.bind(item)

        fun bind(plant: Plant) = with(binding) {
            im.setImageResource(plant.imageId)
            tvTitle.text = plant.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.i_am_item, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(myList[position])
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addMyPhoto(plant: Plant) {
        myList.add(plant)
        notifyDataSetChanged()
    }
}