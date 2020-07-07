package com.fghilmany.themoviedbwithjetpack.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.data.source.remote.RemoteDataSource
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailMovieResponse
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.DetailTvSeriesResponse
import com.fghilmany.themoviedbwithjetpack.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class DataRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val dataRepository = FakeDataRepository(remote)

    private val movieResponse = listOf<MovieEntity>()
    private val movieId = /*movieResponse[0].results[0].id.toString()*/ "419704"
    private val tvResponse = listOf<TvSeriesEntity>()
    private val tvId = /*tvResponse[0].results[0].id.toString()*/ "93533"
    private val detailMovieResponse = DetailMovieResponse()
    private val detailTvResponse = DetailTvSeriesResponse()

    @Test
    fun getListMovie() {
        doAnswer {invocation ->
            (invocation.arguments[0] as RemoteDataSource.GetListMovieCallback)
                .onResponse(movieResponse)
            null
        }.`when`(remote).getListMovie(any())

        val movieEntities = LiveDataTestUtil.getValue(dataRepository.getListMovie())

        verify(remote).getListMovie(any())

        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getListTv() {
        doAnswer {invocation ->
            (invocation.arguments[0] as RemoteDataSource.GetLisTvCallback)
                .onResponse(tvResponse)
            null
        }.`when`(remote).getListTv(any())

        val tvEntities = LiveDataTestUtil.getValue(dataRepository.getListTv())

        verify(remote).getListTv(any())

        assertNotNull(tvEntities)
        assertEquals(tvResponse.size.toLong(), tvEntities.size.toLong())
    }

    @Test
    fun getDetailTv() {
        doAnswer {invocation ->
            (invocation.arguments[0] as RemoteDataSource.GetDetailTvCallback)
                .onResponse(detailTvResponse)
            null
        }.`when`(remote).getDetailTv(any(), eq(tvId))

        val detailTvEntities = LiveDataTestUtil.getValue(dataRepository.getDetailTv(tvId))

        verify(remote).getDetailTv(any(), eq(tvId))

        assertNotNull(detailTvEntities)
        assertEquals(detailTvResponse, detailTvEntities)
    }

    @Test
    fun getDetailMovie() {
        doAnswer {invocation ->
            (invocation.arguments[0] as RemoteDataSource.GetDetailMovieCallback)
                .onResponse(detailMovieResponse)
            null
        }.`when`(remote).getDetailMovie(any(),eq(movieId))

        val detailMovieEntities = LiveDataTestUtil.getValue(dataRepository.getDetailMovie(movieId))

        verify(remote).getDetailMovie(any(),eq(movieId))

        assertNotNull(detailMovieEntities)
        assertEquals(detailMovieResponse, detailMovieEntities)
    }
}