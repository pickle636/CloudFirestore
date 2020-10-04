package com.quizsquiz.cloudfirestore

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import com.quizsquiz.cloudfirestore.db.AppDatabase
import com.quizsquiz.cloudfirestore.models.User

class AddUserViewModel @ViewModelInject constructor(private val db: AppDatabase, application: Application) : AndroidViewModel(application) {

    val user = User("", "", 0)

    fun addUser() {
        db.addNewUser(user)
    }
}