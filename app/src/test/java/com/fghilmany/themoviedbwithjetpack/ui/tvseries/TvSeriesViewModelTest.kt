package com.fghilmany.themoviedbwithjetpack.ui.tvseries

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvSeriesViewModelTest {

    private lateinit var viewModel: TvSeriesViewModel

    @Before
    fun setUp() {
        viewModel = TvSeriesViewModel()
    }

    @Test
    fun getMovies() {
        val tvEntities = viewModel.getMovies()
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities.size)
    }
}