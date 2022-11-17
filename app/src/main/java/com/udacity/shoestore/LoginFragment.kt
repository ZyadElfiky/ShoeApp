package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.accessibility.AccessibilityManagerCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
   private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)

        binding.login.setOnClickListener {
            navigateToWelcome(it)
        }
        binding.signUp.setOnClickListener {
            navigateToWelcome(it)
        }
        return binding.root
    }
    private fun navigateToWelcome(view: View){
    if(binding.edtPass.text.isNotEmpty() && binding.edtEmail.text.isNotEmpty()){
      findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }else {
        Toast.makeText(activity, "Please Enter Email Or Password",  Toast.LENGTH_SHORT).show()
    }
}
}