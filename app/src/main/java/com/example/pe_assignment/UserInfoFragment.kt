package com.example.pe_assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pe_assignment.databinding.FragmentUserInfoBinding

class UserInfoFragment : Fragment() {

    private val userInfoViewModel: UserInfoViewModel by viewModels {
        UserInfoFactory((activity?.application as BaseApplication).repository)
    }
    private lateinit var binding: FragmentUserInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_user_info, container, false
        )

        binding.userInfoLayout = userInfoViewModel

        binding.lifecycleOwner = this

        userInfoViewModel.navigateto.observe(viewLifecycleOwner, Observer { hasFinished ->
//            if (hasFinished == true) {
//                val action = UserInfoDirections.actionUserDetailsFragmentToLoginFragment()
//                NavHostFragment.findNavController(this).navigate(action)
//                userInfoViewModel.doneNavigating()
//            }
        })

        initRecyclerView()

        return binding.root

    }


    private fun initRecyclerView() {
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(this.context)
        displayUsersList()
    }


    private fun displayUsersList() {
        userInfoViewModel.users.observe(viewLifecycleOwner, Observer {
            binding.usersRecyclerView.adapter = MyRecycleViewAdapter(it)
        })

    }
}