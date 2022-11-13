package com.example.catfacts_tugas9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CatAdapter(private val dataCat: List<DataItem?>?) : RecyclerView.Adapter<CatAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val breed: TextView = view.findViewById(R.id.tvBreed)
        val country: TextView = view.findViewById(R.id.tvCountry)
        val origin: TextView = view.findViewById(R.id.tvOrigin)
        val coat: TextView = view.findViewById(R.id.tvCoat)
        val pattern: TextView = view.findViewById(R.id.tvPattern)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.breed.text = dataCat?.get(position)?.breed
        holder.country.text = dataCat?.get(position)?.country
        holder.origin.text = dataCat?.get(position)?.origin
        holder.coat.text = dataCat?.get(position)?.coat
        holder.pattern.text = dataCat?.get(position)?.pattern

        holder.itemView.setOnClickListener{
            val breed = dataCat?.get(position)?.breed
            Toast.makeText(holder.itemView.context, "Kucing keturunan ${breed}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        if (dataCat?.isNotEmpty() == true) {
            return dataCat.size
        }
        return 0
    }

}