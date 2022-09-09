package my.edu.tarc.contact

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import my.edu.tarc.contact.databinding.FragmentAddBinding
import my.edu.tarc.contact.databinding.FragmentSecondBinding
import my.edu.tarc.contact.model.Contact
import my.edu.tarc.contact.viewModel.ContactViewModel


class AddFragment : Fragment() {
    private var _binding : FragmentAddBinding?= null
    private val binding get() = _binding!!

    private  val contactViewModel:ContactViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("Main Activity","onCreate")
        setHasOptionsMenu(true)
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.findItem(R.id.action_save).isVisible = true
        menu.findItem(R.id.action_profile).isVisible = false
        menu.findItem(R.id.action_add).isVisible = false
        menu.findItem(R.id.action_settings).isVisible = false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_save -> {
                val name = binding.editTextTextPersonName.text.toString()
                val phone = binding.editTextPhone2.text.toString()
                val newContact = Contact(name,phone)

                //todo5
                //MainActivity.contactList.add(newContact)
                contactViewModel.insert(newContact)

                //val navController= activity.findNavController(R.id.nav_host_fragment_content_main)

                findNavController().navigateUp()

                Toast.makeText(context, getString(R.string.contact_saved),
                    Toast.LENGTH_SHORT).show()
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main Activity","onDestroyView")
    }
}