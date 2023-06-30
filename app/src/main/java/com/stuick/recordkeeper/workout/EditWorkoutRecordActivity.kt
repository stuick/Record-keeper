package com.stuick.recordkeeper.workout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stuick.recordkeeper.databinding.ActivityEditWorkoutRecordBinding

class EditWorkoutRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditWorkoutRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditWorkoutRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("Name")
        title = "$name Record"
    }
}