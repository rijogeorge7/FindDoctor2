package com.example.data.di.modules

import com.example.data.repository.DoctorsRepository
import com.example.data.repository.DoctorsRepositoryImpl
import com.example.data.webServices.DoctorService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class DataModule {
    @Provides
    internal fun doctorService(retrofit: Retrofit): DoctorService {
        return retrofit.create(DoctorService::class.java)
    }

    @Provides
    internal fun provideDoctorsRepository(doctorsRepositoryImpl: DoctorsRepositoryImpl): DoctorsRepository {
        return doctorsRepositoryImpl
    }
}