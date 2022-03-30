package com.example.myweek6task.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myweek6task.data.NODE_CONTACTS
import com.google.firebase.database.FirebaseDatabase

class ContactViewModel: ViewModel() {

    private var dbContacts = FirebaseDatabase.getInstance().getReference(NODE_CONTACTS)
    private var _result = MutableLiveData<Exception?>()
}