package com.example.spacexappui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacexappui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val rocketLaunchesAdapter = RocketLaunchesAdapter()
    private val rocketsAdapter = RocketsAdapter()

    private var rocketLaunches = mutableListOf<Rocket>()
    private var rockets = mutableListOf<Rocket>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rocketLaunches.add(
            Rocket(
                R.drawable.falconsat01,
                "Starlink 2",
                "CCAES SLC 40",
                "16-12-2014",
                false
            )
        )
        rocketLaunches.add(
            Rocket(
                R.drawable.falcon9,
                "DemoSat",
                "AAAES SLC 40",
                "06-07-2018",
                false
            )
        )
        rocketLaunches.add(
            Rocket(
                R.drawable.demosat02,
                "Falcon 9 Test",
                "CCAES SEC 40",
                "18-03-2019",
                false
            )
        )
        rocketLaunches.add(Rocket(R.drawable.crs, "CRS - 2", "CAAES SLC 40", "18-12-2019", false))

        rockets.add(Rocket(R.drawable.falconsat01, "Falcon 1", "", "", false))
        rockets.add(Rocket(R.drawable.falcon09, "Falcon 9", "", "", true))
        rockets.add(Rocket(R.drawable.demosat02, "Big Falcon Rocket", "", "", false))

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
            binding.launchCardView.isVisible = true
            binding.upcomingDetails.isVisible = true
            binding.rocketLaunchesRecyclerView.isVisible = false
            binding.rocketsRecyclerView.isVisible = false
            binding.launchesTextView.setTextColor(resources.getColor(R.color.black))
            binding.upcomingTextView.setTextColor(resources.getColor(R.color.pink))
            binding.rocketsTextView.setTextColor(resources.getColor(R.color.black))
        }

        binding.launchesTextView.setOnClickListener {
            binding.launchCardView.isVisible = false
            binding.upcomingDetails.isVisible = false
            binding.rocketLaunchesRecyclerView.isVisible = true
            binding.rocketsRecyclerView.isVisible = false
            binding.upcomingTextView.setTextColor(resources.getColor(R.color.black))
            binding.launchesTextView.setTextColor(resources.getColor(R.color.pink))
            binding.rocketsTextView.setTextColor(resources.getColor(R.color.black))
        }

        binding.rocketsTextView.setOnClickListener {
            binding.launchCardView.isVisible = false
            binding.upcomingDetails.isVisible = false
            binding.rocketLaunchesRecyclerView.isVisible = false
            binding.rocketsRecyclerView.isVisible = true
            binding.upcomingTextView.setTextColor(resources.getColor(R.color.black))
            binding.launchesTextView.setTextColor(resources.getColor(R.color.black))
            binding.rocketsTextView.setTextColor(resources.getColor(R.color.pink))
        }
    }
}