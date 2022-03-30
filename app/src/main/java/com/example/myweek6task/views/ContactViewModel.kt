package com.example.myweek6task.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myweek6task.data.NODE_CONTACTS
import com.example.myweek6task.data.UserData
import com.google.firebase.database.FirebaseDatabase

class ContactViewModel: ViewModel() {

    private var dbContacts = FirebaseDatabase.getInstance().getReference(NODE_CONTACTS)
    private var _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?> get() = _result

    fun addContact(contact: UserData){
        contact.id = dbContacts.push().key

        dbContacts.child(contact.id!!).setValue(contact).addOnCompleteListener {
            if(it.isSuccessful){
                _result.value = null
            }else{
                _result.value = it.exception
            }
        }
    }
}