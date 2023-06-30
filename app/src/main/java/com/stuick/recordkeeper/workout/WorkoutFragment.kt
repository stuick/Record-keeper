package com.stuick.recordkeeper.workout

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.stuick.recordkeeper.databinding.FragmentWorkoutBinding

class WorkoutFragment : Fragment(){

    private lateinit var binding: FragmentWorkoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorkoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListener()
    }

    private fun setupClickListener() {
        binding.containerBiceps.setOnClickListener { launchWorkoutRecordScreen("Biceps") }
        binding.containerTriceps.setOnClickListener { launchWorkoutRecordScreen("Triceps") }
        binding.containerShoulder.setOnClickListener { launchWorkoutRecordScreen("Shoulder") }
    }

    private fun launchWorkoutRecordScreen(name: String){
        val intent = Intent(context, EditWorkoutRecordActivity::class.java)
        intent.putExtra("Name", name)
        startActivity(intent)
    }
}