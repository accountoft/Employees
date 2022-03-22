package com.ekipa2.o7task.data
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Employee")

data class Employee (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "id")
    val employeeId: Long = 0,
    val name: String,
    val birthdayDate :Calendar,
    val gender: String,
    val salary: Long,

    )