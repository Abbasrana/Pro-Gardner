package com.example.progardner.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.progardner.R

class SavesFragment : Fragment(R.layout.saves_fragment), Toolbar.OnMenuItemClickListener {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setToolbar()
    }

    fun setToolbar() {
        val toolbar = view?.findViewById<Toolbar>(R.id.toolbarNew)
        val navController = NavHostFragment.findNavController(this)
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
                Toast.makeText(requireActivity(), "Filter is called:", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.search -> {

                Toast.makeText(requireActivity(), "Search is called:", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return false
    }
}