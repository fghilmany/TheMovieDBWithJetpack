package com.fghilmany.themoviedbwithjetpack.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fghilmany.themoviedbwithjetpack.R
import kotlinx.android.synthetic.main.activity_home.*

class FavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        val sectionPagerAdapter = FavoriteSectionPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionPagerAdapter
        tabs.setupWithViewPager(view_pager)

    }
}
