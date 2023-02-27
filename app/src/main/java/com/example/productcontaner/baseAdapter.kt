package com.example.productcontaner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.productcontaner.model.dataItem
import com.squareup.picasso.Picasso


class baseAdapter( var mList: ArrayList<dataItem>): RecyclerView.Adapter<baseAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): baseAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.tickets, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentItem: dataItem = mList[position]
        holder.category.text = currentItem.category
        holder.description.text=currentItem.description
        holder.id.text=currentItem.id.toString()
//        holder.image.text=currentItem.image
        Picasso.get().load(currentItem.image.toUri()).into(holder.image);
        holder.price.text=currentItem.price.toString()
        holder.rating.text=currentItem.rating.rate.toString()
        holder.title.text=currentItem.title

    }

    override fun getItemCount(): Int {
       return mList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var category:TextView  = itemView.findViewById(R.id.category)
        var description:TextView = itemView.findViewById(R.id.description)
        var id:TextView = itemView.findViewById(R.id.id)
        var image:ImageView = itemView.findViewById(R.id.image)
        var price:TextView = itemView.findViewById(R.id.price)
        var rating:TextView = itemView.findViewById(R.id.rating)
        var title:TextView = itemView.findViewById(R.id.title)

    }
}