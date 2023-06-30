package com.stuick.recordkeeper

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import com.stuick.recordkeeper.databinding.ActivityMainBinding
import com.stuick.recordkeeper.running.RunningFragment
import com.stuick.recordkeeper.workout.WorkoutFragment

class MainActivity : AppCompatActivity(), OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.reset_running -> resetRunningRecords()
            R.id.reset_workout -> resetWorkoutRecords()
            R.id.reset_all -> resetAllRecords()
            else -> return super.onOptionsItemSelected(item)
        }

    }

    private fun resetRunningRecords(): Boolean {
        Toast.makeText(this, "Running", Toast.LENGTH_LONG).show()
        return true
    }

    private fun resetWorkoutRecords(): Boolean {
        Toast.makeText(this, "Workout", Toast.LENGTH_LONG).show()
        return true
    }

    private fun resetAllRecords(): Boolean {
        resetRunningRecords()
        resetWorkoutRecords()
        return true
    }


    private fun onRunningClick(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, RunningFragment())
        }
        return true
    }

    private fun onWorkoutClick(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, WorkoutFragment())
        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.nav_running -> onRunningClick()
        R.id.nav_workout -> onWorkoutClick()
        else -> false
    }
}