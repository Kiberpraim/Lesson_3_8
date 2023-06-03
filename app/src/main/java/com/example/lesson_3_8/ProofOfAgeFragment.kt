package com.example.lesson_3_8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lesson_3_8.databinding.FragmentProofOfAgeBinding

class ProofOfAgeFragment : Fragment() {
    private lateinit var _binding: FragmentProofOfAgeBinding
    private var SuccessfulDialogFragment = SuccessfulDialogFragment()
    private var UnsuccessfulDialogFragment = UnsuccessfulDialogFragment()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProofOfAgeBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding.buttonNextProofOfAge.setOnClickListener { view ->
            if (_binding.editTextAnswer.text.isEmpty() || _binding.editTextTIN.text.isEmpty()) {
                Toast.makeText(context, "Заполните все поля!", Toast.LENGTH_SHORT).show()
            } else if (_binding.editTextTIN.text.length != 12){
                Toast.makeText(context, "Ведите ИНН корректно \n Длина должен быть 12 данный момент: ${_binding.editTextTIN.text.length}!", Toast.LENGTH_SHORT).show()
            }else if (2023 - _binding.editTextAnswer.text.toString().toInt() >= 18 && _binding.editTextTIN.text.length == 12) {
                SuccessfulDialogFragment.show(requireActivity().supportFragmentManager, "MAIN")
            }else{
                UnsuccessfulDialogFragment.show(requireActivity().supportFragmentManager, "main")
            }
        }
    }

}
