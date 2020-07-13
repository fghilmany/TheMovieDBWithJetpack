package com.fghilmany.themoviedbwithjetpack.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.fghilmany.themoviedbwithjetpack.data.source.local.LocalDataSource
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.data.source.remote.RemoteDataSource
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.*
import com.fghilmany.themoviedbwithjetpack.utils.AppExecutors
import com.fghilmany.themoviedbwithjetpack.utils.LiveDataTestUtil
import com.fghilmany.themoviedbwithjetpack.utils.PagedListUtil
import com.fghilmany.themoviedbwithjetpack.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class DataRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val dataRepository =
        FakeDataRepository(
            remote,
            local,
            appExecutors
        )


    @Test
    fun getListMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        dataRepository.getListMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(listOf(MovieEntity())))

        verify(local).getAllMovies()

        assertNotNull(movieEntities)
    }

    @Test
    fun getListTv() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvSeriesEntity>
        `when`(local.getAllTvSeries()).thenReturn(dataSourceFactory)
        dataRepository.getListTv()

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(listOf(TvSeriesEntity())))

        verify(local).getAllTvSeries()

        assertNotNull(tvEntities)
    }

}