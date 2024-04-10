package com.example.spacexappui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RocketsAdapter : RecyclerView.Adapter<RocketsAdapter.ViewHolder>() {

    var rockets: MutableList<Rocket> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rocket_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rockets.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(rockets[position])
        holder.rocketCoverImageView.setImageResource(rockets[position].rocketCover)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rocketCoverImageView =
            itemView.findViewById<ImageView>(R.id.rocketCoverImageView)
        private val rocketNameTextView = itemView.findViewById<TextView>(R.id.rocketNameTextView)
        private val isActivateTextView = itemView.findViewById<TextView>(R.id.isActiveTextView)

        fun bind(rocket: Rocket) {
            rocketNameTextView.text = rocket.rocketName
            if(rocket.isActive){
                isActivateTextView.setBackgroundResource(R.drawable.active_rocket_shape)
                isActivateTextView.text = "ACTIVE"
            }
            else{
                isActivateTextView.setBackgroundResource(R.drawable.inactive_rocket_shape)
                isActivateTextView.text = "INACTIVE"
            }
        }
    }
}