package com.eselman.android.shoestore.ui.fragments.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.eselman.android.shoestore.R
import com.eselman.android.shoestore.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.buttonLogIn.setOnClickListener {
            login()
        }

        binding.buttonCreateAccount.setOnClickListener {
            login()
        }

        return binding.root
    }

    private fun login() {
        when {
            editTextEmail.text.toString().isEmpty() -> {
                editTextEmail.error = "Please enter your email"
            }
            editTextPassword.text.toString().isEmpty() -> {
                editTextPassword.error = "Please enter your password"
            }
            else -> {
                val action = LoginFragmentDirections.actionLoginToWelcome()
                findNavController().navigate(action)
            }
        }
    }
}