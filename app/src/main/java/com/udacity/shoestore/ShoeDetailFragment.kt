package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeStoreViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.*


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {
    private val viewModel by activityViewModels<ShoeStoreViewModel>()
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
        R.layout.fragment_shoe_detail, container, false)
        var fragmentShoe = Shoe("", "", "", "")
        binding.shoe = fragmentShoe
        // Set click listeners for each button
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.
            actionShoeDetailFragmentToShoeListFragment())
        }
        binding.saveButton.setOnClickListener { view: View ->
            if (!fragmentShoe.name.isNullOrEmpty() && !fragmentShoe.size.isNullOrEmpty()
                && !fragmentShoe.company.isNullOrEmpty()) {
                viewModel.addShoe(fragmentShoe)
                findNavController().navigate(
                    ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
                )
            }
            else {
                Toast.makeText(activity, "Please fill out the name, company, and size fields", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }

}