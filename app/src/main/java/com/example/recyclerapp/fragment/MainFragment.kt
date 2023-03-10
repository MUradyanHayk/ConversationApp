package com.example.recyclerapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recyclerapp.screen.MainFragmentScreen

class MainFragment : Fragment() {

    var screen: MainFragmentScreen? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        screen = MainFragmentScreen(requireContext())
        return screen
    }
}