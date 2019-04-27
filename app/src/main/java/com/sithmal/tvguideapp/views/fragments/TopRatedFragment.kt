package com.sithmal.tvguideapp.views.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.sithmal.tvguideapp.R
import com.sithmal.tvguideapp.views.viewmodels.TopRatedViewModel
import kotlinx.android.synthetic.main.top_rated_fragment.*


class TopRatedFragment : Fragment() {

    companion object {
        fun newInstance() = TopRatedFragment()
    }

    init {

    }

    private lateinit var viewModel: TopRatedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.top_rated_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TopRatedViewModel::class.java)

        viewModel.count.observe(this, Observer {
            textView.text = it.toString()
        })

        button.setOnClickListener {
            viewModel.count.value = viewModel.count.value?.plus(2)
            Navigation.findNavController(it).navigate(R.id.movieDetailsFragment)
        }
    }

}
