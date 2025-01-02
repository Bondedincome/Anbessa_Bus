package com.example.anbessabus.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.anbessabus.R
import com.example.anbessabus.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Handle login button click
        binding.loginButton.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                authenticateUser(email, password)
            } else {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Navigate to Signup
        binding.signupRedirect.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }

        return binding.root
    }

    private fun authenticateUser(email: String, password: String) {
        // Dummy authentication logic
        if (email == "test@example.com" && password == "password") {
            Toast.makeText(requireContext(), "Login Successful", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_loginFragment_to_nav_home)
        } else {
            Toast.makeText(requireContext(), "Invalid credentials", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
