package com.quizsquiz.cloudfirestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.quizsquiz.cloudfirestore.AddUserViewModel
import com.quizsquiz.cloudfirestore.MainViewModel
import com.quizsquiz.cloudfirestore.R
import com.quizsquiz.cloudfirestore.databinding.FragmentAddUserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddUserFragment : Fragment() {
    private val viewModel: AddUserViewModel by viewModels()
    lateinit var binding: FragmentAddUserBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_user, container, false)
        binding.vm = viewModel
        binding.btnAddUser.setOnClickListener {
            viewModel.addUser()
            findNavController().navigate(AddUserFragmentDirections.actionAddUserFragmentToUsersFragment())
        }
        return binding.root
    }


}