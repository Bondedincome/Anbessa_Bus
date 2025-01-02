package com.example.anbessabus.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.anbessabus.R
import com.example.anbessabus.databinding.FragmentSignupBinding

class SignupFragment : Fragment() {

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)

        // Handle signup button click
        binding.signupButton.setOnClickListener {
            val fullName = binding.fullNameInput.text.toString()
            val email = binding.signupEmailInput.text.toString()
            val password = binding.signupPasswordInput.text.toString()
            val confirmPassword = binding.confirmPasswordInput.text.toString()

            if (fullName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                if (password == confirmPassword) {
                    createUser(fullName, email, password)
                } else {
                    Toast.makeText(requireContext(), "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Navigate to Login
        binding.loginRedirect.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

        return binding.root
    }

    private fun createUser(fullName: String, email: String, password: String) {
        // Dummy signup logic
        Toast.makeText(requireContext(), "User Created Successfully", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
