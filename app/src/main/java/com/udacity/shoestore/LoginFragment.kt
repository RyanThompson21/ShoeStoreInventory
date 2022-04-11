package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login, container, false)
        // Set click listeners for both buttons
        binding.loginButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.
            actionLoginFragmentToWelcomeFragment())
        }
        binding.createButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.
            actionLoginFragmentToWelcomeFragment())
        }
        return binding.root
    }

}