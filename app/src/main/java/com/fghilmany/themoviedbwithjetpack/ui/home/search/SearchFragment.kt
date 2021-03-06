package com.fghilmany.themoviedbwithjetpack.ui.home.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fghilmany.themoviedbwithjetpack.R
import com.fghilmany.themoviedbwithjetpack.data.source.remote.StatusResponse
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by sharedViewModel()

    companion object {
        val TAG = SearchFragment::class.java.simpleName

        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            Log.e("CEK_VM_SHARED", "movie.toString()")

            val  searchAdapter = SearchAdapter()
            viewModel.getMovies().observe(this, Observer { movie ->
                if (movie != null){
                    when (movie.status){
                        StatusResponse.SUCCESS ->{
                            Log.e("CEK_VM_SHARED", movie.toString())
                            searchAdapter.setMovies(movie.body)
                            searchAdapter.notifyDataSetChanged()
                        }
                        StatusResponse.ERROR -> {

                            Toast.makeText(this.context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }

                    }
                }
            })
            rv_search.layoutManager = LinearLayoutManager(activity?.applicationContext)
            rv_search.setHasFixedSize(true)
            rv_search.adapter = searchAdapter

        }
    }


}
