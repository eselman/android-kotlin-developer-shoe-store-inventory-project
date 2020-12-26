package com.eselman.android.shoestore.ui.fragments.shoes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.eselman.android.shoestore.R
import com.eselman.android.shoestore.databinding.FragmentShoesListBinding
import com.eselman.android.shoestore.ui.customView.ShoeItemView
import com.eselman.android.shoestore.viewmodel.ShoesViewModel

class ShoesListFragment : Fragment() {
    private lateinit var binding: FragmentShoesListBinding
    private lateinit var listLayoutContainer: LinearLayout
    private val shoesViewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)
        listLayoutContainer = binding.shoesListLayoutContainer

        binding.addShoeFloatingActionButton.setOnClickListener {
            val action = ShoesListFragmentDirections.actionShoesListToShoeDetails()
            findNavController().navigate(action)
        }

        shoesViewModel.loadShoesList()
        observeViewModel()

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.shoe_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout) {
            val action = ShoesListFragmentDirections.actionShoesListToLogin()
            findNavController().navigate(action)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun observeViewModel () {
        shoesViewModel.shoesListLiveData.observe(viewLifecycleOwner, { shoesList ->
            listLayoutContainer.removeAllViews()
            shoesList.forEach { shoe ->
                val shoeItemView = ShoeItemView(activity as FragmentActivity, listLayoutContainer, shoe)
                shoeItemView.bindItem()
            }
        })
    }
}