package com.genius.wasylews.articleslistapp.view

import android.os.Bundle
import android.view.Menu
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.genius.wasylews.articleslistapp.R
import com.genius.wasylews.articleslistapp.view.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Activity doesn't see navController in FragmentContainerView
        // So we need to get it manually
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment

        appBarConfiguration = AppBarConfiguration(navHostFragment.navController.graph, drawer)
        NavigationUI.setupWithNavController(
            toolbar,
            navHostFragment.navController,
            appBarConfiguration
        )
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_container)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
