package com.fghilmany.themoviedbwithjetpack.ui.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.ui.movie.MovieViewModel
import org.junit.Test
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class FavoriteMovieViewModelTest {

    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observerFavorite: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var viewModel: FavoriteMovieViewModel

    private lateinit var liveMovie: MutableLiveData<PagedList<MovieEntity>>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel.getMovies()
        liveMovie = MutableLiveData()
    }

    @Test
    fun getMovies() {
        val pagedList = Mockito.mock(PagedList::class.java) as PagedList<MovieEntity>
        liveMovie.value = pagedList

        Mockito.`when`(viewModel.getMovies()).thenReturn(liveMovie)
        viewModel.getMovies().observeForever(observerFavorite)
        Mockito.verify(observerFavorite).onChanged(pagedList)
    }
}