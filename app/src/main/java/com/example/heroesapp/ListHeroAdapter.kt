package com.example.heroesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListHeroAdapter(val listHero : ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.listViewHolder>(){

    class listViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName : TextView = itemView.findViewById(R.id.hero_name)
        var tvDetail : TextView = itemView.findViewById(R.id.hero_detail)
        var imgHero : ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): listViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_item_hero, viewGroup, false)
        return listViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: listViewHolder, position: Int) {
        val hero = listHero[position]

        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgHero)

        holder.tvName.text = hero.name
        holder.tvDetail.text = hero.detail
    }
}