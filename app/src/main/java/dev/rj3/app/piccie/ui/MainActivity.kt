package dev.rj3.app.piccie.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import dev.rj3.app.piccie.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController: NavController = findNavController(R.id.nav_host_fragment)
        navBar.setupWithNavController(navController)

        navBar.setOnNavigationItemReselectedListener {
            Toast.makeText(this@MainActivity, it.itemId,Toast.LENGTH_SHORT).show()

        }
        setSupportActionBar(toolbar)


    }
}
