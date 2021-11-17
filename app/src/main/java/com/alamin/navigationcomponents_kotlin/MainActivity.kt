package com.alamin.navigationcomponents_kotlin

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController ;
    private  lateinit var drawerLayout :DrawerLayout ;
    private lateinit var appBarConfiguration:AppBarConfiguration;
    private lateinit var listener : NavController.OnDestinationChangedListener;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = findNavController(R.id.nav_host_fragment);
        drawerLayout = findViewById(R.id.drawerLayout);

        NavigationUI.setupWithNavController(navigationView,navController);
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,drawerLayout)
    }
}