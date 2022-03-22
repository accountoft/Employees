package com.ekipa2.o7task

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment(private val listener: DatePickerDialog.OnDateSetListener) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
// Use the current date as the default date in the picker
        val c = Calendar.getInstance()

        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val datePicker = DatePickerDialog(requireNotNull(context), listener, year, month, day)
        datePicker.datePicker.maxDate= System.currentTimeMillis()

// Create a new instance of DatePickerDialog and return it
        return datePicker
    }
}