package com.affluencesystems.testthis.room.repo

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.affluencesystems.testthis.room.dao.UserDao
import com.affluencesystems.testthis.room.models.User

class UserRepo {
    var userDao: UserDao

    constructor(userDao: UserDao) {
        this.userDao = userDao
    }

    fun getUsers(): LiveData<List<User>> = this.userDao.getAllUsers()

    fun insertUser(user: User) {
        AsyncInsert(userDao, user)
    }

    fun deleteUser(user: User) = this.userDao.deleteUser(user)

    fun updateUser(user: User) = this.userDao.updateUser(user)

    class AsyncInsert(userDao: UserDao, user: User) : AsyncTask<User, Unit, Unit>() {
        private lateinit var userDao: UserDao
        private lateinit var user: User
        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to [.execute]
         * by the caller of this task.
         *
         * This method can call [.publishProgress] to publish updates
         * on the UI thread.
         *
         * @param params The parameters of the task.
         *
         * @return A result, defined by the subclass of this task.
         *
         * @see .onPreExecute
         * @see .onPostExecute
         *
         * @see .publishProgress
         */
        override fun doInBackground(vararg params: User?): Unit {
            userDao.insertUser(params)
        }

    }
}