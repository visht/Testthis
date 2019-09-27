package com.affluencesystems.testthis.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.affluencesystems.testthis.room.db.UserDb
import com.affluencesystems.testthis.room.models.User
import com.affluencesystems.testthis.room.repo.UserRepo

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var userRepo: UserRepo? = null

    init {
        userRepo = UserRepo(UserDb.getDb(application.applicationContext).getUserDao())
    }

    fun setdataToModel(userdata: User) = userRepo!!.insertUser(userdata)

    fun deleteDataFromModel(userdata: User) = userRepo!!.deleteUser(userdata)

    fun updateUser(userdata: User) = userRepo!!.updateUser(userdata)

    fun getAllUsers(): LiveData<List<User>> = userRepo!!.getUsers()
}