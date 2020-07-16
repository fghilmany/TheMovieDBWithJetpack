package com.fghilmany.themoviedbwithjetpack.ui.tvseries

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.fghilmany.themoviedbwithjetpack.data.DataRepository
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.TvSeries
import com.fghilmany.themoviedbwithjetpack.vo.Resource
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvSeriesViewModelTest {

    private lateinit var viewModel: TvSeriesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvSeriesEntity>>>


    @Mock
    private lateinit var pagedList: PagedList<TvSeriesEntity>

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        viewModel = TvSeriesViewModel(dataRepository)
    }

    @Test
    fun getMovies() {
        val dataDummy = Resource.success(pagedList)

        val dataMovie = MutableLiveData<Resource<PagedList<TvSeriesEntity>>>()
        dataMovie.value = dataDummy

        `when`(dataRepository.getListTv()).thenReturn(dataMovie)
        val tvEntities = viewModel.getMovies().value
        assertNotNull(tvEntities)

        viewModel.getMovies().observeForever(observer)
        Mockito.verify(observer).onChanged(dataDummy)
    }
}