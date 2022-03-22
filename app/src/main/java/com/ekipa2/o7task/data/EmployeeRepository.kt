package com.ekipa2.o7task.data

import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EmployeeRepository @Inject constructor(private val EmployeeDao: EmployeeDao) {

    fun getEmployees() = EmployeeDao.getEmployees()

    fun getEmployee(employeeId: Long) = EmployeeDao.getEmployee(employeeId)


    suspend fun createEmployee( name: String, birthDate: Calendar, gender: String, salary: Long) {
        val employee = Employee(
            name = name,
            birthdayDate = birthDate,
            gender = gender,
            salary=salary,

        )
        EmployeeDao.insertEmployee(employee)
    }

    fun getAverageAge()=EmployeeDao.getAverageAge()

    fun getMaxSalary()=EmployeeDao.getMaxSalary()

    fun getGenderRatio()= EmployeeDao.getGenderRatio()


}