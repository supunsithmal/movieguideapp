package com.sithmal.tvguideapp.views.fragments

import android.support.v4.app.Fragment

abstract class BaseFragment: Fragment() {

    abstract fun handleLoading()
    abstract fun handleData()
    abstract fun handleError()

}