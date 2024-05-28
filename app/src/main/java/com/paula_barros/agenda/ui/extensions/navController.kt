package com.paula_barros.agenda.ui.extensions

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment


fun AppCompatActivity.findNavController(@IdRes navHostID: Int) : NavController {
    val navHostFragment = supportFragmentManager.findFragmentById(navHostID) as NavHostFragment
    return navHostFragment.navController
}