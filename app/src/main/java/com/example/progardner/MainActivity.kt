package com.example.progardner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), Toolbar.OnMenuItemClickListener,
    NavigationBarView.OnItemSelectedListener {
    private lateinit var navController: NavController
    private lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavHost()
        setToolbar()
    }

    private fun setUpNavHost() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        bottomNav = findViewById(R.id.navigation)
        bottomNav.setupWithNavController(navController)
        bottomNav.setOnItemSelectedListener(this)
    }

    private fun setToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.plantsFragment,
                R.id.calendarFragment,
                R.id.tipsFragment,
                R.id.nutrientsFragment,
                R.id.savesFragment
            )
        )
        toolbar?.let {
            it.setupWithNavController(navController, appBarConfiguration)
            it.setOnMenuItemClickListener(this)
        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.filter -> {
                Toast.makeText(this@MainActivity, "Filter is called:", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.search -> {

                Toast.makeText(this@MainActivity, "Search is called:", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.tipsFragment -> {
                navController.navigate(R.id.tipsFragment)
                true
            }
            R.id.calendarFragment -> {
                navController.navigate(R.id.calendarFragment)
                true
            }
            R.id.plantsFragment -> {
                navController.navigate(R.id.plantsFragment)
                true
            }
            R.id.nutrientsFragment -> {
                navController.navigate(R.id.nutrientsFragment)
                true
            }
            R.id.savesFragment -> {
                navController.navigate(R.id.savesFragment)
                true
            }
            else -> false
        }
    }
}