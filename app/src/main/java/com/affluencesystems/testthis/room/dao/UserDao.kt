package com.affluencesystems.testthis.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.affluencesystems.testthis.room.models.User

@Dao
interface UserDao {

    @Query("select * from user_table")
    fun getAllUsers(): LiveData<List<User>>

    @Insert(onConflict = REPLACE)
    fun insertUser(user: Array<out User?>)

    @Delete
    fun deleteUser(user: User)

    @Update
    fun updateUser(user: User)
}