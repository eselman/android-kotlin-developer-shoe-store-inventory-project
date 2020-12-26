package com.eselman.android.shoestore.ui.fragments.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.eselman.android.shoestore.R
import com.eselman.android.shoestore.databinding.FragmentOnboardingInstructionsBinding

class OnboardingInstructionsFragment : Fragment() {

    private lateinit var binding:FragmentOnboardingInstructionsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_onboarding_instructions, container, false)

        binding.goToShoesList.setOnClickListener {
            val action = OnboardingInstructionsFragmentDirections.actionInstructionsToShoesList()
            findNavController().navigate(action)
        }

        return binding.root
    }
}