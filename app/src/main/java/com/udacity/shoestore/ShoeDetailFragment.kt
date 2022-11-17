package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {


    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentShoeDetailBinding.inflate(inflater, container, false)
        viewModel =  (activity as MainActivity).viewModel
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.save.setOnClickListener {
            viewModel.addNewShoe()
            it.findNavController().navigate(
                R.id.action_shoeDetailFragment_to_shoeListFragment
            )
        }
        binding.cancel.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_shoeDetailFragment_to_shoeListFragment
            )
        }



        return binding.root
    }

}