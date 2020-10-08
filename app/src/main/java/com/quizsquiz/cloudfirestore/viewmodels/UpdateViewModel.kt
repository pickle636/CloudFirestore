package com.quizsquiz.cloudfirestore

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import com.quizsquiz.cloudfirestore.db.AppDatabase

class UpdateViewModel @ViewModelInject constructor(private val db: AppDatabase, application: Application) : AndroidViewModel(application) {


}