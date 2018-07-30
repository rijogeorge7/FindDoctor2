package com.example.data.di.components

import com.example.data.DataManager
import com.example.data.DataManagerImpl
import com.example.data.di.modules.DataModule
import com.example.data.di.modules.NetworkModule
import com.example.data.repository.DoctorsRepositoryImpl
import dagger.Component


@Component(modules = arrayOf(DataModule::class, NetworkModule::class))
interface DataComponent {
    fun inject(DataManager : DataManagerImpl)
    fun inject(DoctorsRepositoryImpl : DoctorsRepositoryImpl)
}