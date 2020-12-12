package com.kluivert.knews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottomNav = findViewById<BottomNavigationView>(R.id.nav_bottom)
        val navController = findNavController(R.id.fragmentContainerView)

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.feeds,R.id.bookmarks,R.id.search))
        setupActionBarWithNavController(navController,appBarConfiguration)
        bottomNav.setupWithNavController(navController)
    }
}