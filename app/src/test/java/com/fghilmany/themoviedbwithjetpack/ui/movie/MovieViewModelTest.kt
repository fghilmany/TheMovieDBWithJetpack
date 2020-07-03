package com.fghilmany.themoviedbwithjetpack.ui.movie

import com.fghilmany.themoviedbwithjetpack.ui.tvseries.TvSeriesViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp(){
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val tvEntities = viewModel.getMovies()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities.size)
    }
}