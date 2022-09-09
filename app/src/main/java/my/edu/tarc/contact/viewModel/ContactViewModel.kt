package my.edu.tarc.contact.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.edu.tarc.contact.dao.ContactDao
import my.edu.tarc.contact.database.ContactDatabase
import my.edu.tarc.contact.model.Contact
import my.edu.tarc.contact.repository.ContactRepository

class ContactViewModel (application: Application):
    AndroidViewModel(application){
        //create a UI dataset
        var contactList:LiveData<List<Contact>>
        private val contactRepository: ContactRepository

        init{
            val contactDao = ContactDatabase.getDatabase(application).contactDao()

            contactRepository = ContactRepository(contactDao)

            contactList = contactRepository.allContact
        }
    //launching a coroutine
    fun insert(contact: Contact) =viewModelScope.launch{
        contactRepository.insert(contact)
    }

    fun delete(contact: Contact) =viewModelScope.launch{
        contactRepository.delete(contact)
    }

    fun update(contact: Contact) =viewModelScope.launch{
        contactRepository.update(contact)
    }
}