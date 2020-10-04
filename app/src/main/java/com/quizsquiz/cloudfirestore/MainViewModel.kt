package com.quizsquiz.cloudfirestore

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.quizsquiz.cloudfirestore.db.AppDatabase
import com.quizsquiz.cloudfirestore.models.User
import kotlinx.coroutines.launch


class MainViewModel @ViewModelInject constructor(private val db: AppDatabase, application: Application) : AndroidViewModel(application) {
    var users = MutableLiveData<List<User>>()


    fun getUsers() {
        viewModelScope.launch {
            users.postValue(db.getUsers())
        }
    }
}