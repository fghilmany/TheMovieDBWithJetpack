package com.fghilmany.themoviedbwithjetpack.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.fghilmany.themoviedbwithjetpack.data.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.Movie
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
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observer: Observer<List<Movie>>

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        viewModel = MovieViewModel(dataRepository)
    }
    @Test
    fun getMovies() {
        val dataDummy = listOf<Movie>()
        val dataMovie = MutableLiveData<List<Movie>>()
        dataMovie.value = dataDummy
        Mockito.`when`(dataRepository.getListMovie()).thenReturn(dataMovie)
        val moviesEntities = viewModel.getMovies().value
        Mockito.verify<DataRepository>(dataRepository).getListMovie()
        assertNotNull(moviesEntities)

        viewModel.getMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dataDummy)
    }
}