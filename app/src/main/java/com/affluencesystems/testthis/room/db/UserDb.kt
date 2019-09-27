package com.affluencesystems.testthis.room.db

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.affluencesystems.testthis.room.dao.UserDao
import com.affluencesystems.testthis.room.models.User

@Database(entities = [User::class], version = 1)
abstract class UserDb : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {
        fun getDb(context: Context): UserDb = Room.databaseBuilder(context.applicationContext
        ,UserDb::class.java, "User.db").build()
    }

}