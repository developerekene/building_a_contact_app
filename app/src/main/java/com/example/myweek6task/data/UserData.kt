package com.example.myweek6task.data

import com.google.firebase.database.Exclude

data class UserData(
    @get:Exclude
    var id: String? = null,
    var surName: String? = null,
    var firstName: String? = null,
    var contactNumber: String? = null,
    var email: String? = null,
    var address: String? = null
) {
}