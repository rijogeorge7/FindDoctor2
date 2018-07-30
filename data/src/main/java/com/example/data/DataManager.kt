package com.example.data

import com.example.data.model.DoctorProfile
import io.reactivex.Observable

interface DataManager {
    fun getDoctorsInArea(location: String, skip: Int, limit: Int, specialty_uid: String?, insurance_uid: String?) : Observable<List<DoctorProfile>>
}

