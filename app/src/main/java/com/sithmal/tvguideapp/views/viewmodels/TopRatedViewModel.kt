package com.sithmal.tvguideapp.views.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;

class TopRatedViewModel : ViewModel() {

    var count = MutableLiveData<Int>()


    init {
        count.value = 0
    }

}
