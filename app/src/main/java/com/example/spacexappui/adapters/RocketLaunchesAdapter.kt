package com.example.spacexappui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spacexappui.R
import com.example.spacexappui.data.Rocket

class RocketLaunchesAdapter : RecyclerView.Adapter<RocketLaunchesAdapter.ViewHolder>() {

    var rockets: MutableList<Rocket> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.launch_view, parent, false)
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
        private val modelNumberTextView = itemView.findViewById<TextView>(R.id.modelNumberTextView)
        private val launchDateTextView = itemView.findViewById<TextView>(R.id.launchDateTextView)

        fun bind(rocket: Rocket) {
            rocketNameTextView.text = rocket.rocketName
            modelNumberTextView.text = rocket.modelNumber
            launchDateTextView.text = rocket.launchDate
        }
    }
}