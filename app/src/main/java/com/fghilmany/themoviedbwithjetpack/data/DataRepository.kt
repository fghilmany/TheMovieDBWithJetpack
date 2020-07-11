package com.fghilmany.themoviedbwithjetpack.data

import androidx.lifecycle.LiveData
import com.fghilmany.themoviedbwithjetpack.data.source.local.LocalDataSource
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.MovieEntity
import com.fghilmany.themoviedbwithjetpack.data.source.local.entity.TvSeriesEntity
import com.fghilmany.themoviedbwithjetpack.data.source.remote.ApiResponse
import com.fghilmany.themoviedbwithjetpack.data.source.remote.RemoteDataSource
import com.fghilmany.themoviedbwithjetpack.data.source.remote.response.*
import com.fghilmany.themoviedbwithjetpack.utils.AppExecutors
import com.fghilmany.themoviedbwithjetpack.vo.Resource

class DataRepository (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors)
    : Datasource {

    companion object{
        @Volatile
        private var instance : DataRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource,  localData: LocalDataSource, appExecutors: AppExecutors): DataRepository =
            instance
                ?: synchronized(this){
                instance
                    ?: DataRepository(
                        remoteDataSource, localData, appExecutors
                    )
            }
    }

    override fun getListMovie(): LiveData<Resource<List<MovieEntity>>> {
        return object : NetworkBoundResource<List<MovieEntity>, List<Movie>>(appExecutors){
            override fun loadFromDB(): LiveData<List<MovieEntity>> =
                localDataSource.getAllMovies()


            override fun shouldFetch(data: List<MovieEntity>?): Boolean =
                data == null || data.isEmpty()


            override fun createCall(): LiveData<ApiResponse<List<Movie>>> =
                remoteDataSource.getListMovie()


            override fun saveCallResult(data: List<Movie>) {
                val movieLlist = ArrayList<MovieEntity>()
                for (response in data){
                    val movie = MovieEntity(response.id,
                        response.posterPath,
                        response.title,
                        response.voteAverage,
                        response.release_date)
                    movieLlist.add(movie)
                }
                localDataSource.insertMovie(movieLlist)
            }

        }.asLiveData()


    }

    override fun getListTv(): LiveData<Resource<List<TvSeriesEntity>>> {
        return object : NetworkBoundResource<List<TvSeriesEntity>, List<TvSeries>>(appExecutors){
            override fun loadFromDB(): LiveData<List<TvSeriesEntity>> =
                localDataSource.getAllTvSeries()


            override fun shouldFetch(data: List<TvSeriesEntity>?): Boolean =
                data == null || data.isEmpty()


            override fun createCall(): LiveData<ApiResponse<List<TvSeries>>> =
                remoteDataSource.getListTv()


            override fun saveCallResult(data: List<TvSeries>) {
                val tvList = ArrayList<TvSeriesEntity>()
                for (response in data){
                    val movie = TvSeriesEntity(response.id,
                        response.name,
                        response.posterPath,
                        response.voteAverage,
                        response.first_air_date)
                    tvList.add(movie)
                }
                localDataSource.insertTvSeries(tvList)
            }

        }.asLiveData()

    }

    override fun getDetailTv(idTv: String): LiveData<Resource<TvSeriesEntity>> {
        return object : NetworkBoundResource<TvSeriesEntity, DetailTvSeriesResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<TvSeriesEntity> =
                localDataSource.getDetailTvSeries(idTv)


            override fun shouldFetch(data: TvSeriesEntity?): Boolean =
                data?.overview == "" || data == null


            override fun createCall(): LiveData<ApiResponse<DetailTvSeriesResponse>> =
                remoteDataSource.getDetailTv(idTv)


            override fun saveCallResult(data: DetailTvSeriesResponse) {
                val tvDetail = TvSeriesEntity(
                    data.id,
                    data.name,
                    data.posterPath,
                    data.voteAverage,
                    data.first_air_date,
                    data.backdropPath,
                    data.overview,
                    data.status,
                    data.number_of_seasons,
                    false
                )
                localDataSource.insertDetailTv(tvDetail)
            }

        }.asLiveData()
    }

    override fun getDetailMovie(idMovie: String): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, DetailMovieResponse>(appExecutors){
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getDetailMovie(idMovie)


            override fun shouldFetch(data: MovieEntity?): Boolean =
                data?.overview == "" || data == null


            override fun createCall(): LiveData<ApiResponse<DetailMovieResponse>> =
                remoteDataSource.getDetailMovie(idMovie)


            override fun saveCallResult(data: DetailMovieResponse) {
                val movieDetail = MovieEntity(
                    data.id,
                    data.posterPath,
                    data.title,
                    data.voteAverage,
                    data.release_date,
                    data.backdropPath,
                    data.overview,
                    data.status,
                    false
                )
                localDataSource.insertDetailMovie(movieDetail)
            }

        }.asLiveData()
    }


    override fun getSearch(query: String): LiveData<ApiResponse<List<Search>>> =
        remoteDataSource.getSearchMovie(query)

    override fun getFavoriteMovie(): LiveData<List<MovieEntity>> =
        localDataSource.getFavoriteMovies()

    override fun getFavoriteTvSeries(): LiveData<List<TvSeriesEntity>> =
        localDataSource.getFavoriteTvSeries()

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }

    override fun setTvSeriesFavorite(tvSeries: TvSeriesEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setTvFavorite(tvSeries, state) }
    }


}