package com.example.anbessabus

import android.os.Bundle
//import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SubmitComplaintActivity : AppCompatActivity() {

    private val reasonOfComplaintList = listOf(
        "Bus delay", "Driver misconduct", "Overcrowding", "Broken seats", "Other"
    )
    private val busNumbers = listOf("Bus 101", "Bus 102", "Bus 103")
    private val stations = listOf("Station A", "Station B", "Station C")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complaint)

        // Spinners
        val spinnerReason: Spinner = findViewById(R.id.spinner_reason_of_complaint)
        val spinnerBusNumber: Spinner = findViewById(R.id.spinner_bus_number)
        val spinnerStation: Spinner = findViewById(R.id.spinner_station)

        // Populate Spinners
        setSpinnerAdapter(spinnerReason, reasonOfComplaintList)
        setSpinnerAdapter(spinnerBusNumber, busNumbers)
        setSpinnerAdapter(spinnerStation, stations)

        // Radio Groups
        val radioGroup1: RadioGroup = findViewById(R.id.radio_group_sub_city)
        val radioGroup2: RadioGroup = findViewById(R.id.radio_group_sub_city_1)
        val radioGroup3: RadioGroup = findViewById(R.id.radio_group_sub_city_2)

        // Submit Button
        val btnSubmit: Button = findViewById(R.id.btn_submit_complaint)
        btnSubmit.setOnClickListener {
            val selectedReason = spinnerReason.selectedItem.toString()
            val selectedBusNumber = spinnerBusNumber.selectedItem.toString()
            val selectedStation = spinnerStation.selectedItem.toString()
            val selectedSubCity = getSelectedSubCity(radioGroup1, radioGroup2, radioGroup3)

            if (selectedSubCity.isNullOrEmpty()) {
                Toast.makeText(this, "Please select a sub-city", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Process the selected values
            Toast.makeText(
                this,
                "Complaint Submitted:\nReason: $selectedReason\nBus: $selectedBusNumber\nSub-city: $selectedSubCity\nStation: $selectedStation",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    // Helper to set Spinner Adapter
    private fun setSpinnerAdapter(spinner: Spinner, data: List<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    // Helper to get selected sub-city
    private fun getSelectedSubCity(vararg radioGroups: RadioGroup): String? {
        for (radioGroup in radioGroups) {
            val checkedRadioButtonId = radioGroup.checkedRadioButtonId
            if (checkedRadioButtonId != -1) {
                val radioButton: RadioButton = findViewById(checkedRadioButtonId)
                return radioButton.text.toString()
            }
        }
        return null
    }
}
