package com.quizsquiz.cloudfirestore

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.quizsquiz.cloudfirestore.db.AppDatabase
import com.quizsquiz.cloudfirestore.models.User
import kotlinx.coroutines.launch

class AddUserViewModel @ViewModelInject constructor(private val db: AppDatabase, application: Application) : AndroidViewModel(application) {

    val user = User("", "", 0)

    fun addUser() {
        viewModelScope.launch {
            db.addNewUser(user)
        }

    }
}