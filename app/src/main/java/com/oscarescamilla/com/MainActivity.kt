package com.oscarescamilla.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {


    private lateinit var  navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment) // hace referencia al fragment root
        NavigationUI.setupActionBarWithNavController(this, navController) // habilitamos el boton de regreso indicando de que fragment depende
    }

    override fun onSupportNavigateUp(): Boolean {
        // sobre escribimos con nuestro navController
        return navController.navigateUp()
    }


}