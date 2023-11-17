package com.example.infirmary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.infirmary.Fragments.MessagesFragment
import com.example.infirmary.Fragments.NotificationsFragment
import com.example.infirmary.Fragments.RequestsFragment
import com.example.infirmary.databinding.ActivityMainSecBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainSec : AppCompatActivity() {
    private lateinit var binding: ActivityMainSecBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainSecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        // Load the default fragment
        loadFragment(DashboardFragment())

        // Set up bottom navigation item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.iDash -> {
                    loadFragment(DashboardFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.iMess -> {
                    loadFragment(MessagesFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.iReq -> {
                    loadFragment(RequestsFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.iNoti -> {
                    loadFragment(NotificationsFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                // Add other menu items as needed
                else -> false
            }
        }

        // Set up floating action button click listener
        fab.setOnClickListener {
            // Handle FAB click
            // Add your custom action here
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
