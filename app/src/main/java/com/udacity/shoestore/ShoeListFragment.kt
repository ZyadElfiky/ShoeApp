package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeViewBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {


    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShoeViewModel
    private lateinit var shoeBinding:ShoeViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        viewModel =  (activity as MainActivity).viewModel
        viewModel.shoesList.observe(viewLifecycleOwner, Observer {
            for (i in 0 until it.size){
                createNewView(it[i]);
            }
        })

        binding.addShoe.setOnClickListener {
            it.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())

        }


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.shoe_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun createNewView(shoe:Shoe) {
        val view=View.inflate(context,R.layout.shoe_view,null)
        shoeBinding=DataBindingUtil.bind(view)!!
        shoeBinding.shoe=shoe
        binding.linearLayout.addView(shoeBinding.root)
    }
}