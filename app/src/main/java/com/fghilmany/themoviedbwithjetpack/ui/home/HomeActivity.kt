package com.fghilmany.themoviedbwithjetpack.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fghilmany.themoviedbwithjetpack.R
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setLogo(R.drawable.ic_tmdb_logo_long)
        supportActionBar?.setDisplayUseLogoEnabled(true)

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionPagerAdapter
        tabs.setupWithViewPager(view_pager)

        supportActionBar?.elevation = 0f
    }
}
