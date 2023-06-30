package com.stuick.recordkeeper.running

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.stuick.recordkeeper.databinding.FragmentRunningBinding

class RunningFragment : Fragment() {

    private lateinit var binding: FragmentRunningBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRunningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    override fun onResume() {
        super.onResume()
        displayRecords()
    }

    private fun setupClickListeners() {
        binding.container2km.setOnClickListener { launchRunningRecordScreen("2km") }
        binding.container5km.setOnClickListener { launchRunningRecordScreen("5km") }
        binding.container8km.setOnClickListener { launchRunningRecordScreen("8km") }
        binding.container10km.setOnClickListener { launchRunningRecordScreen("10km") }

    }

    private fun displayRecords() {
//        val runningPreferences = context?.getSharedPreferences("running", Context.MODE_PRIVATE)
        val runningPreferences = requireContext().getSharedPreferences("running", Context.MODE_PRIVATE)
        binding.textView2kmValue.text = runningPreferences.getString("2km record", null)
        binding.textView5kmValue.text = runningPreferences.getString("5km record", null)
        binding.textView8kmValue.text = runningPreferences.getString("8km record", null)
        binding.textView10kmValue.text = runningPreferences.getString("10km record", null)
        binding.textView2kmDate.text = runningPreferences.getString("2km date",null)
        binding.textView5kmDate.text = runningPreferences.getString("5km date",null)
        binding.textView8kmDate.text = runningPreferences.getString("8km date",null)
        binding.textView10kmDate.text = runningPreferences.getString("10km date",null)

    }

    private fun launchRunningRecordScreen(distance: String) {

        val intent = Intent(context, EditRunningRecordActivity::class.java)
        intent.putExtra("Distance", distance)
        startActivity(intent)
    }
}