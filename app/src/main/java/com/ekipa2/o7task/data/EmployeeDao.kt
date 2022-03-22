package com.ekipa2.o7task.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ekipa2.o7task.data.Employee
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface EmployeeDao {

    @Query("SELECT * FROM Employee ORDER BY name")
    fun getEmployees(): Flow<List<Employee>>


    @Query("SELECT * FROM Employee WHERE id = :employeeId")
    fun getEmployee(employeeId: Long): Flow<Employee>

    @Query("SELECT birthdayDate FROM Employee Order by birthdayDate ")
    fun getAverageAge(): Flow<List<Calendar>>

    @Query("SELECT MAX(salary) FROM Employee")
    fun getMaxSalary(): Flow<Long>

    @Query("SELECT cast(COUNT(*) AS float) as `num` from Employee Group by Gender")
    fun getGenderRatio(): Flow<List<Int>>

    @Insert
    suspend fun insertEmployee(employee: Employee): Long


}