package com.example.spacexappui.ui

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.spacexappui.R
import com.example.spacexappui.databinding.ActivityMainBinding
import com.example.spacexappui.fragments.LaunchesFragment
import com.example.spacexappui.fragments.RocketsFragment
import com.example.spacexappui.fragments.UpcomingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            goToFragment(UpcomingFragment())
        }

        binding.upcomingTextView.setOnClickListener {
            goToFragment(UpcomingFragment())
            fetchTabColor(binding.upcomingTextView)
        }

        binding.launchesTextView.setOnClickListener {
            goToFragment(LaunchesFragment())
            fetchTabColor(binding.launchesTextView)
        }

        binding.rocketsTextView.setOnClickListener {
            goToFragment(RocketsFragment())
            fetchTabColor(binding.rocketsTextView)
        }
    }

    private fun goToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    private fun fetchTabColor(textView: TextView) {
        binding.upcomingTextView.setTextColor(getColor(R.color.black))
        binding.launchesTextView.setTextColor(getColor(R.color.black))
        binding.rocketsTextView.setTextColor(getColor(R.color.black))
        textView.setTextColor(ContextCompat.getColor(this, R.color.pink))
    }
}