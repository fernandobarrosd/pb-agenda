package com.paula_barros.agenda.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.paula_barros.agenda.databinding.ActivityMainBinding
import com.paula_barros.agenda.ui.extensions.findNavController


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar()
    }



    private fun setupToolbar() {
        setSupportActionBar(binding.mainToolBar)
        val navController = findNavController(binding.mainNavHost.id)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.mainToolBar.setupWithNavController(navController, appBarConfiguration)
        binding.mainToolBar.title = ""

        navController.addOnDestinationChangedListener {_, _, _ ->
            binding.mainToolBar.title = ""
        }
    }

}


