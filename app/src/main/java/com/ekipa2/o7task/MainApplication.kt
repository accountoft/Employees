package com.ekipa2.o7task

import android.app.Application
import com.ekipa2.o7task.data.AppDatabase
import com.ekipa2.o7task.data.EmployeeRepository

class MainApplication: Application() {

    val database by lazy { AppDatabase.getInstance(this) }
    val repository by lazy { EmployeeRepository(database.employeeDao()) }

}