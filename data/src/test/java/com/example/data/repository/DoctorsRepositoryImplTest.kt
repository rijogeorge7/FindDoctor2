package com.example.data.repository

import com.example.data.DataManagerImpl
import com.example.data.mock.MockJson
import com.example.data.webServices.DoctorService
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import retrofit2.Call
import retrofit2.Response
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.MockResponse
import org.junit.BeforeClass


class DoctorsRepositoryImplTest {

    //for setting dagger component
    //val doctorsRepository = Mockito.mock(DoctorsRepository::class.java)
    //@InjectMocks lateinit var dataManager: DataManagerImpl

    val doctorService = Mockito.mock(DoctorService::class.java)
    @InjectMocks lateinit var repository : DoctorsRepositoryImpl
    inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)
    var callMock = mock<Call<String>>()


    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getDoctorsInArea_validParams_doctorList() {

        `when`(doctorService.getDoctors(anyString(), anyInt(), any(), any(), any(), any(), any(), any(), any(), any(), any(), anyInt()))
                .thenReturn(callMock)
        val response = Response.success(MockJson.jsonStr)
        `when`(callMock.execute()).thenReturn(response)
        val doctorsList = repository.getDoctorsInArea("37.773,-122.413,100",0,10,null, null)
        Assert.assertEquals(1,doctorsList.size)
    }
}