package com.sithmal.tvguideapp.views.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sithmal.tvguideapp.R
import com.sithmal.tvguideapp.views.viewmodels.UpComingViewModel

class UpComingFragment : Fragment() {

    companion object {
        fun newInstance() = UpComingFragment()
    }

    private lateinit var viewModel: UpComingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.up_coming_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UpComingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
