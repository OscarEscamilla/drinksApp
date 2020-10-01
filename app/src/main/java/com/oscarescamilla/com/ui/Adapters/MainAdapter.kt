package com.oscarescamilla.com.ui.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oscarescamilla.com.R
import com.oscarescamilla.com.base.BaseViewHolder
import com.oscarescamilla.com.data.model.Drink
import kotlinx.android.synthetic.main.drink_row.view.*

class MainAdapter(private val context: Context, private val items: List<Drink>, private val itemClickListener: OnDrickClickListener)
    : RecyclerView.Adapter<BaseViewHolder<*>>(){

    interface OnDrickClickListener{

        fun onDrinkClick(drink: Drink)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return  MainViewHolder(LayoutInflater.from(context).inflate( R.layout.drink_row, parent, false))
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is MainViewHolder -> holder.bind(items[position], position)
        }
    }

    inner class MainViewHolder(itemView: View): BaseViewHolder<Drink>(itemView){

        override fun bind(item: Drink, position: Int) {
            // load image in img_drink with synthetic anotation
            Glide.with(context).load(item.image).centerCrop().into(itemView.img_drink)
            itemView.tv_drink_name.text = item.nombre
            itemView.tv_drink_description.text = item.descripcion

            itemView.setOnClickListener { itemClickListener.onDrinkClick(item) }

        }

    }

}