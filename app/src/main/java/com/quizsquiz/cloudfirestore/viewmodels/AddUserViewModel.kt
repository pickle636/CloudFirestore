package com.quizsquiz.cloudfirestore

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.quizsquiz.cloudfirestore.db.AppDatabase
import com.quizsquiz.cloudfirestore.models.User
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class AddUserViewModel @ViewModelInject constructor(private val db: AppDatabase, application: Application) : AndroidViewModel(application) {
    @RequiresApi(Build.VERSION_CODES.O)
    val user = User("", "", 0, LocalDateTime.now().toString())

    fun addUser() {
        viewModelScope.launch {
            db.addNewUser(user)
        }
    }
}