package com.fghilmany.themoviedbwithjetpack.ui.home.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.fghilmany.themoviedbwithjetpack.data.source.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.SearchEntity

class SearchViewModel(private val dataRepository: DataRepository) : ViewModel() {

    var query = MutableLiveData<String>()

    fun setQuery(query: String){
        this.query.value = query
        Log.e("CEKQUEY", query)
    }

    fun getMovies(): LiveData<List<SearchEntity>> = Transformations.switchMap(query){query ->
        dataRepository.getSearch(query)
    }
}