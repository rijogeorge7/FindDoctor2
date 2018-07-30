package com.rijogeorge.finddoctor2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.data.DataManager
import com.example.data.DataManagerImpl
import com.example.data.model.DoctorProfile
import com.rijogeorge.finddoctor2.ui.search.SearchFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SearchFragment.newInstance())
                    .commitNow()
            //DataManagerImpl().getDoctorsInArea()
            DataManagerImpl().getDoctorsInArea("37.773,-122.413,100",0,10,"pediatrician", "aetna-aetnabasichmo")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            {
                                doctorProfiles -> onSuccess(doctorProfiles)
                            },
                            {
                                e -> onFailure(e)
                            }
                    )
        }
    }

    private fun onFailure(e: Throwable?) {
        var i =0
    }

    private fun onSuccess(doctorProfiles: List<DoctorProfile>?) {
        var i =0
    }

}
