package com.stuick.recordkeeper.editrecord

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.stuick.recordkeeper.databinding.ActivityEditRecordBinding
import com.stuick.recordkeeper.databinding.ActivityEditRunningRecordBinding

class EditRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRecordBinding
    private val runningPreferences by lazy { getSharedPreferences("running", Context.MODE_PRIVATE) }
    private val distance by lazy { intent.getStringExtra("Distance") }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUi()
        displayRecord()


//        val applicationPreferences = getDefaultSharedPreferences(this)
//        applicationPreferences.edit {
//            putString("Some application data ","Application value")
//        }
//
//        val activityPreferences = getPreferences(Context.MODE_PRIVATE)
//        activityPreferences.edit {
//            putInt("data",3)
//        }

//        val fileNamePreferences = getSharedPreferences("some file",Context.MODE_PRIVATE)
//        fileNamePreferences.edit {
//            putBoolean("bookstall", true)
//        }
    }

    private fun setupUi() {
        title = "$distance Record"
        binding.buttonSave.setOnClickListener {
            savingRecord()
            finish()
        }
        binding.buttonClearRecord.setOnClickListener {
            clearingRecord()
            finish()
        }
    }

    private fun displayRecord() {
        binding.editTextRecord.setText(runningPreferences.getString("$distance record", null))
        binding.editTextDate.setText(runningPreferences.getString("$distance date", null))
    }

    private fun savingRecord() {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()

        runningPreferences.edit {
            putString("$distance record", record)
            putString("$distance date", date)
        }
    }

    private fun clearingRecord() {
        runningPreferences.edit {
            remove("$distance record")
            remove("$distance date")
        }
    }

    data class ScreenData(
        val record: String,
        val sharedPreferences: String,
        val recordFieldHint: String
    )
}