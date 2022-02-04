package com.osama.moviedemo.ui.detail

import com.osama.moviedemo.ui.base.BaseViewModel
import com.osama.moviedemo.utils.network.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(networkHelper: NetworkHelper) : BaseViewModel(networkHelper)  {


    override fun onCreate() {

    }
}