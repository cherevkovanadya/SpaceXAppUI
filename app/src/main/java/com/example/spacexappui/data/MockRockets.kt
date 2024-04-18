package com.example.spacexappui.data

import com.example.spacexappui.R

object MockRockets {
    val mockRocketLaunches = mutableListOf<Rocket>(
        Rocket(
            R.drawable.falconsat01,
            "Starlink 2",
            "CCAES SLC 40",
            "16-12-2014",
            false
        ),
        Rocket(
            R.drawable.falcon9,
            "DemoSat",
            "AAAES SLC 40",
            "06-07-2018",
            false
        ),
        Rocket(
            R.drawable.demosat02,
            "Falcon 9 Test",
            "CCAES SEC 40",
            "18-03-2019",
            false
        ),
        Rocket(
            R.drawable.crs,
            "CRS - 2",
            "CAAES SLC 40",
            "18-12-2019",
            false
        )
    )

    val mockRockets = mutableListOf<Rocket>(
        Rocket(R.drawable.falconsat01, "Falcon 1", "", "", false),
        Rocket(R.drawable.falcon09, "Falcon 9", "", "", true),
        Rocket(R.drawable.demosat02, "Big Falcon Rocket", "", "", false)
    )
}