package com.example.data.repository

import com.example.data.model.DoctorProfile


interface DoctorsRepository {
   fun getDoctorsInArea(location: String, skip: Int, limit: Int, specialty_uid: String?, insurance_uid: String?) : List<DoctorProfile>
}