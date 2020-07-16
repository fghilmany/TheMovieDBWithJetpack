package com.fghilmany.themoviedbwithjetpack.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fghilmany.themoviedbwithjetpack.data.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.vo.Resource
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest{
    private lateinit var viewModelMovie: DetailViewModel
    private lateinit var viewModelTv: DetailViewModel
    private val dummyMovie = MovieEntity()
    private val dummyTv = TvSeriesEntity()
    private val idMovie = "550"
    private val idTv = "9813"

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observerMovie: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var observerTv: Observer<Resource<TvSeriesEntity>>


    @Before
    fun setUp(){
        //MockitoAnnotations.initMocks(this)
        viewModelMovie = DetailViewModel(dataRepository)
        viewModelMovie.selectedMovie(idMovie)
        viewModelTv = DetailViewModel(dataRepository)
        viewModelTv.selectedTvSeries(idTv)
    }

    @Test
    fun getDetailMovie() {
        val movie = MutableLiveData<Resource<MovieEntity>>()
        val resourceMovie = Resource.success(dummyMovie)
        movie.value = resourceMovie
        val tv = MutableLiveData<Resource<TvSeriesEntity>>()
        val resourceTv = Resource.success(dummyTv)
        tv.value = resourceTv

        `when`(dataRepository.getDetailMovie(idMovie.toString())).thenReturn(movie)
       viewModelMovie.getDetailMovie.observeForever(observerMovie)
        verify(observerMovie).onChanged(resourceMovie)

        `when`(dataRepository.getDetailTv(idTv.toString())).thenReturn(tv)
        viewModelTv.getDetailTvSeries.observeForever(observerTv)
        verify(observerTv).onChanged(resourceTv)
    }
}