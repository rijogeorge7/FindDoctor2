package com.rijogeorge.finddoctor2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rijogeorge.finddoctor2.ui.search.SearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SearchFragment.newInstance())
                    .commitNow()
        }
    }

}
