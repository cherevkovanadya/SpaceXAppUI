package com.example.spacexappui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacexappui.MockRockets.mockRocketLaunches
import com.example.spacexappui.MockRockets.mockRockets
import com.example.spacexappui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val rocketLaunchesAdapter = RocketLaunchesAdapter()
    private val rocketsAdapter = RocketsAdapter()

    private var rocketLaunches = mockRocketLaunches
    private var rockets = mockRockets

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rocketLaunchesRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rocketLaunchesRecyclerView.adapter = rocketLaunchesAdapter
        rocketLaunchesAdapter.rockets = rocketLaunches
        rocketLaunchesAdapter.notifyDataSetChanged()

        binding.rocketsRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rocketsRecyclerView.adapter = rocketsAdapter
        rocketsAdapter.rockets = rockets
        rocketsAdapter.notifyDataSetChanged()

        binding.upcomingTextView.setOnClickListener {
            binding.launchCardView.visibility = View.VISIBLE
            binding.upcomingDetails.visibility = View.VISIBLE
            binding.rocketLaunchesRecyclerView.visibility = View.GONE
            binding.rocketsRecyclerView.visibility = View.GONE
            binding.launchesTextView.setTextColor(getColor(R.color.black))
            binding.upcomingTextView.setTextColor(getColor(R.color.pink))
            binding.rocketsTextView.setTextColor(getColor(R.color.black))
        }

        binding.launchesTextView.setOnClickListener {
            binding.launchCardView.visibility = View.GONE
            binding.upcomingDetails.visibility = View.GONE
            binding.rocketLaunchesRecyclerView.visibility = View.VISIBLE
            binding.rocketsRecyclerView.visibility = View.GONE
            binding.upcomingTextView.setTextColor(getColor(R.color.black))
            binding.launchesTextView.setTextColor(getColor(R.color.pink))
            binding.rocketsTextView.setTextColor(getColor(R.color.black))
        }

        binding.rocketsTextView.setOnClickListener {
            binding.launchCardView.visibility = View.GONE
            binding.upcomingDetails.visibility = View.GONE
            binding.rocketLaunchesRecyclerView.visibility = View.GONE
            binding.rocketsRecyclerView.visibility = View.VISIBLE
            binding.upcomingTextView.setTextColor(getColor(R.color.black))
            binding.launchesTextView.setTextColor(getColor(R.color.black))
            binding.rocketsTextView.setTextColor(getColor(R.color.pink))
        }
    }
}