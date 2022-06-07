package com.drinks.com

import android.content.Intent
import android.content.IntentSender
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.drinks.com.util.toast
import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.appupdate.testing.FakeAppUpdateManager
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.google.android.play.core.tasks.Task
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController


    private val APP_UPDATE_TYPE_SUPPORTED = AppUpdateType.IMMEDIATE

    private  val REQUEST_UPDATE = 100



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // init nav controller
        // seteamos como fragment contenedor al nav_host_fragment
        navController =
            findNavController(R.id.nav_host_fragment) // hace referencia al fragment root contenedor
        NavigationUI.setupActionBarWithNavController(
            this,
            navController
        ) // habilitamos el boton de regreso indicando de que fragment depende


        checkForUpdates()

    }


    private fun checkForUpdates() {

        val REQUEST_CODE = 100
        val TAG = "IAU"
        val appUpdateManager = AppUpdateManagerFactory.create(baseContext)

        // Returns an intent object that you use to check for an update.
        val appUpdateInfoTask = appUpdateManager.appUpdateInfo

        // Checks that the platform will allow the specified type of update.
        appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
            ) {
                toast("Update Disponible")
                try {
                    appUpdateManager.startUpdateFlowForResult(
                        appUpdateInfo,
                        AppUpdateType.IMMEDIATE,
                        this,
                        REQUEST_CODE)
                }catch (e: IntentSender.SendIntentException){
                    toast(e.message.toString())
                    Log.e(TAG, e.message.toString())
                }
            }else{
                toast("Update NO Disponible")
            }
        }

        appUpdateInfoTask.addOnFailureListener {
            toast(it.message.toString())
            Log.e(TAG, it.message.toString())
        }

    }




    // rewrite back button
    override fun onSupportNavigateUp(): Boolean {
        // sobre escribimos con nuestro navController
        return navController.navigateUp()
    }


}