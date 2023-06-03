package com.example.lesson_3_8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lesson_3_8.databinding.FragmentAuthorizationBinding

class AuthorizationFragment : Fragment() {
    private lateinit var _binding: FragmentAuthorizationBinding
    private var UnsuccessfulDialogFragment = UnsuccessfulDialogFragment()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return _binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.buttonNextAuthorization.setOnClickListener { view ->
            if (_binding.editTextAge.text.isEmpty() || _binding.editTextName.text.isEmpty() || _binding.editTextSurname.text.isEmpty()) {
                Toast.makeText(context, "Заполните все поля!", Toast.LENGTH_SHORT).show()
            } else if (_binding.editTextAge.text.toString().toInt() >= 18) {
                findNavController().navigate(R.id.action_authorizationFragment_to_proofOfAgeFragment )
            } else {
                UnsuccessfulDialogFragment.show(requireActivity().supportFragmentManager, "main")
            }
        }

    }


}