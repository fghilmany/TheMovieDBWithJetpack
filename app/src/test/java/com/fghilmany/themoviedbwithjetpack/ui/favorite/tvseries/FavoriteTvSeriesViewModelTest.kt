package com.fghilmany.themoviedbwithjetpack.ui.favorite.tvseries

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import org.junit.Test
import org.junit.Before
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class FavoriteTvSeriesViewModelTest {

    @get:Rule
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observerFavorite: Observer<PagedList<TvSeriesEntity>>

    @Mock
    private lateinit var viewModel: FavoriteTvSeriesViewModel

    private lateinit var liveMovie: MutableLiveData<PagedList<TvSeriesEntity>>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel.getMovies()
        liveMovie = MutableLiveData()
    }

    @Test
    fun getMovies() {
        val pagedList = mock(PagedList::class.java) as PagedList<TvSeriesEntity>
        liveMovie.value = pagedList

        `when`(viewModel.getMovies()).thenReturn(liveMovie)
        viewModel.getMovies().observeForever(observerFavorite)
        verify(observerFavorite).onChanged(pagedList)
    }
}