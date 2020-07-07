package com.fghilmany.themoviedbwithjetpack.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fghilmany.themoviedbwithjetpack.data.source.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailMovieResponse
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailTvSeriesResponse
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest{
    private lateinit var viewModelMovie: DetailViewModel
    private lateinit var viewModelTv: DetailViewModel
    private val dummyMovie = DetailMovieResponse()
    private val dummyTv = DetailTvSeriesResponse()
    private val idMovie = dummyMovie.id
    private val idTv = dummyTv.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observerMovie: Observer<DetailMovieResponse>

    @Mock
    private lateinit var observerTv: Observer<DetailTvSeriesResponse>


    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        viewModelMovie = DetailViewModel(dataRepository)
        viewModelMovie.selectedMovie(idMovie.toString())
        viewModelTv = DetailViewModel(dataRepository)
        viewModelTv.selectedTvSeries(idTv.toString())
    }

    @Test
    fun getDetailMovie() {
        val movie = MutableLiveData<DetailMovieResponse>()
        movie.value = dummyMovie
        val tv = MutableLiveData<DetailTvSeriesResponse>()
        tv.value = dummyTv

        Mockito.`when`(dataRepository.getDetailMovie(idMovie.toString())).thenReturn(movie)
        val movieEntity = viewModelMovie.getDetailMovie().value
        assertNotNull(movieEntity)
        Mockito.verify(dataRepository).getDetailMovie(idMovie.toString())
        viewModelMovie.getDetailMovie().observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(dummyMovie)

        Mockito.`when`(dataRepository.getDetailTv(idTv.toString())).thenReturn(tv)
        val tvEntity = viewModelTv.getDetailTvSeries().value
        assertNotNull(tvEntity)
        Mockito.verify(dataRepository).getDetailTv(idTv.toString())
        viewModelTv.getDetailTvSeries().observeForever(observerTv)
        Mockito.verify(observerTv).onChanged(dummyTv)
    }
}