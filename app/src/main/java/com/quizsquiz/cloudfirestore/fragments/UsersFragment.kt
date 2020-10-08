package com.quizsquiz.cloudfirestore.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.quizsquiz.cloudfirestore.MainViewModel
import com.quizsquiz.cloudfirestore.R
import com.quizsquiz.cloudfirestore.adapter.UsersAdapter
import com.quizsquiz.cloudfirestore.databinding.FragmentUsersBinding
import com.quizsquiz.cloudfirestore.models.User
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_users.*

@AndroidEntryPoint
class UsersFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()
    lateinit var binding: FragmentUsersBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_users, container, false)
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(UsersFragmentDirections.actionUsersFragmentToAddUserFragment())
        }
        viewModel.getUsers()

        binding.vm = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        viewModel.users.observe(viewLifecycleOwner, { list ->
            Log.e("rv", "triggered")
            binding.rvUsers.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = UsersAdapter(list, fun(book: User, longPress: Boolean) {
                    listItemClicked(book, longPress)
                })
            }
        })
    }
    private fun listItemClicked(user: User, longPress: Boolean) {
        when (longPress) {
            true -> {
                viewModel.deleteUser(user)
                viewModel.getUsers()
            }
            false -> Toast.makeText(context, "short press detected", Toast.LENGTH_SHORT).show()
        }

    }
}