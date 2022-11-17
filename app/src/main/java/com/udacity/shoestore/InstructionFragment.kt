package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding


class InstructionFragment : Fragment() {

    private lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstructionBinding.inflate(inflater, container, false)

        binding.navigationButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_instructionFragment_to_shoeListFragment)
        }
        return binding.root
    }

}