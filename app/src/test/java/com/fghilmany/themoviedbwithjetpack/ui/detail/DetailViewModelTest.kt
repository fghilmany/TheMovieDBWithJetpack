package com.fghilmany.themoviedbwithjetpack.ui.detail

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailViewModelTest{
    private lateinit var viewModelMovie: DetailViewModel
    private lateinit var viewModelTv: DetailViewModel
    private val dummyMovie = DataDummy.getDummyMovie()[0]
    private val dummyTv = DataDummy.getDummyTv()[0]
    private val idMovie = dummyMovie.movieId
    private val idTv = dummyTv.movieId

    @Before
    fun setUp(){
        viewModelMovie = DetailViewModel()
        viewModelMovie.selectedMovie(idMovie)
        viewModelTv = DetailViewModel()
        viewModelTv.selectedMovie(idTv)
    }

    @Test
    fun getDetailMovie() {
        viewModelMovie.selectedMovie(dummyMovie.movieId)
        val movieEntity = viewModelMovie.getDetailMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.imagePath, movieEntity.imagePath)

        viewModelTv.selectedMovie(dummyTv.movieId)
        val tvEntity = viewModelTv.getDetailMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyTv.movieId, tvEntity.movieId)
        assertEquals(dummyTv.title, tvEntity.title)
        assertEquals(dummyTv.overview, tvEntity.overview)
        assertEquals(dummyTv.imagePath, tvEntity.imagePath)
    }
}