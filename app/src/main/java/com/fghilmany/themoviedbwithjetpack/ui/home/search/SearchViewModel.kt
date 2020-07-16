package com.fghilmany.themoviedbwithjetpack.ui.home.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.fghilmany.themoviedbwithjetpack.data.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.remote.ApiResponse
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.Search

class SearchViewModel(private val dataRepository: DataRepository) : ViewModel() {

    var query = MutableLiveData<String>()

    fun setQuery(query: String){
        this.query.value = query
        Log.e("CEKQUEY", query)
    }

    fun getMovies(): LiveData<ApiResponse<List<Search>>> = Transformations.switchMap(query){ query ->
        dataRepository.getSearch(query)
    }
}