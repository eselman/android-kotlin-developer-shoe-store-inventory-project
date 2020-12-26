package com.eselman.android.shoestore.ui.fragments.shoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.eselman.android.shoestore.R
import com.eselman.android.shoestore.databinding.FragmentShoeDetailBinding
import com.eselman.android.shoestore.models.Shoe
import com.eselman.android.shoestore.viewmodel.ShoesViewModel

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private val shoesViewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.buttonSave.setOnClickListener {
            val newShoe = Shoe(binding.shoeNameEditText.text.toString(),
                    binding.shoeSizeEditText.text.toString().toDouble(),
                    binding.shoeCompanyEditText.text.toString(),
                    binding.shoeDescriptionEditText.text.toString())

            shoesViewModel.addShoe(newShoe)
        }

        binding.buttonCancel.setOnClickListener {
            goBackToShoesList()
        }

        observeViewModel()
        return binding.root
    }

    private fun observeViewModel() {
        shoesViewModel.shoeAddedEvent.observe(viewLifecycleOwner, {
            if (it == true) {
                goBackToShoesList()
            }
        })
    }

    private fun goBackToShoesList() {
        val action = ShoeDetailFragmentDirections.actionGoToShoesList()
        findNavController().navigate(action)
    }
}