package com.example.myweek6task.views

import android.net.wifi.WifiConfiguration.AuthAlgorithm.strings
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myweek6task.R
import com.example.myweek6task.data.UserData
import com.example.myweek6task.databinding.FragmentAddContactBinding
import com.example.myweek6task.databinding.FragmentContactBinding

class AddContactFragment : DialogFragment() {
    private var _binding: FragmentAddContactBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddContactBinding.inflate(inflater, container, false)

        viewModel = ViewModelProviders.of(this).get(ContactViewModel::class.java)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.result.observe(viewLifecycleOwner) {
            val message = if (it == null) {
                getString(R.string.added_contact)
            } else {
                getString(R.string.error, it.message)
            }
            Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
            dismiss()
        }
        binding.buttonToAddValues.setOnClickListener {
            val mySurName = binding.surnameText.text.toString().trim()
            val myFirstName = binding.firstnameText.text.toString().trim()
            val myPhoneNumb = binding.contactText.text.toString().trim()
            val myEmail = binding.emailText.text.toString().trim()
            val myAddress = binding.addressText.text.toString().trim()

            if(mySurName.isEmpty()){
                binding.surnameText.error = "This field is required"
                return@setOnClickListener
            }
            if(myFirstName.isEmpty()){
                binding.firstnameText.error = "This field is required"
                return@setOnClickListener
            }
            if(myPhoneNumb.isEmpty()){
                binding.contactText.error = "This field is required"
                return@setOnClickListener
            }
            if(myEmail.isEmpty()){
                binding.emailText.error = "This field is required"
                return@setOnClickListener
            }

            if(myAddress.isEmpty()){
                binding.addressText.error = "This field is required"
                return@setOnClickListener
            }

            val contact = UserData()
            contact.surName = mySurName
            contact.firstName = myFirstName
            contact.contactNumber = myPhoneNumb
            contact.email = myEmail
            contact.address = myAddress

            viewModel.addContact(contact)
        }
    }
}