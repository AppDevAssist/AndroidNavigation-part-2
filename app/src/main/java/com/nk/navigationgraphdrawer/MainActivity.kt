package com.nk.navigationgraphdrawer

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController: NavController
    lateinit var drawerLayout: DrawerLayout
    lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController


        drawerLayout = findViewById(R.id.drawer_layout)

        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)


        toolbar.setupWithNavController(navController, appBarConfiguration)
        findViewById<NavigationView>(R.id.nav_view)
            .setupWithNavController(navController)

    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)

        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}