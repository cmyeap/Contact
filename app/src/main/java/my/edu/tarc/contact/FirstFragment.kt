package my.edu.tarc.contact

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import my.edu.tarc.contact.databinding.FragmentFirstBinding
import my.edu.tarc.contact.viewModel.ContactViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val contactViewModel: ContactViewModel by viewModels ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("Main Activity","onViewCreated")

        val contactAdapter = ContactAdapter()

        binding.recyclerViewContact.layoutManager = LinearLayoutManager(activity?.applicationContext)
        binding.recyclerViewContact.adapter = contactAdapter
    }



    //   contactViewModel.contactList.observe(viewLifecycleOwner){
    //        if(it.isEmpty()) {
    //            Toast.makeText(context, getString() R . string . no_record, Toast.LENGTH_SHORT).show()
    //        }else{
    //                contactAdapter.setContact(it)
    //            }
    //        }
    //    }


    override fun onDestroyView() {
        Log.d("Main Activity","onDestroyView")
        super.onDestroyView()
        _binding = null
    }


}