package com.quizsquiz.cloudfirestore.db

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.quizsquiz.cloudfirestore.models.User
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class AppDatabase @Inject constructor() {

    private val db = Firebase.firestore

    suspend fun addNewUser(user: User): String {
        var result = ""
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                result = "User added with ID: ${documentReference.id}"
            }
            .addOnFailureListener { e ->
                result = "Error adding user: $e"
            }.await()
        return result
    }

    suspend fun getUsers(): List<User> {
        val list = mutableListOf<User>()
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val user = document.toObject<User>()
                    user.id = document.id
                    list.add(user)
                }
                Log.e("TAG", list.toString())
            }
            .addOnFailureListener { exception ->
                Log.w("getUsers", "Error getting user.", exception)
            }.await()
        return list
    }

    suspend fun deleteUser(user: User) {
        db.collection("users").document(user.id)
            .delete()
            .addOnSuccessListener { Log.d("Delete", "User successfully deleted!") }
            .addOnFailureListener { e -> Log.w("Delete", "Error deleting user", e) }.await()
    }

    suspend fun updateUser(user: User) {
        val washingtonRef = db.collection("users").document(user.id)
        washingtonRef
            .update("name", user.name, "age", user.age)
            .addOnSuccessListener { Log.d("Update", "User successfully updated!") }
            .addOnFailureListener { e -> Log.w("Update", "Error updating user", e) }.await()
    }
}
