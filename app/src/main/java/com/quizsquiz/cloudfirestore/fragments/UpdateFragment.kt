package com.quizsquiz.cloudfirestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.quizsquiz.cloudfirestore.R
import com.quizsquiz.cloudfirestore.UpdateViewModel
import com.quizsquiz.cloudfirestore.databinding.FragmentUsersBinding


class UpdateFragment : Fragment() {
    private val viewModel: UpdateViewModel by viewModels()
    lateinit var binding: FragmentUsersBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_users, container, false)


        return binding.root
    }
}