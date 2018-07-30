package com.example.data

import com.example.data.model.DoctorProfile
import com.example.data.repository.DoctorsRepository
import io.reactivex.observers.TestObserver
import org.junit.Test
import org.junit.Before
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class DataManagerImplTest {

    val doctorsRepository = Mockito.mock(DoctorsRepository::class.java)
    @InjectMocks lateinit var dataManager:  DataManagerImpl

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    fun getDoctorsInArea() {
        `when`(doctorsRepository.getDoctorsInArea(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenReturn(ArrayList<DoctorProfile>())
        val testSub = TestObserver<List<DoctorProfile>>()
        dataManager.getDoctorsInArea("37.773,-122.413,100",0,10,null, null)
                .subscribe(testSub)
        testSub.assertNoErrors()
        testSub.assertValueCount(1)
        testSub.assertComplete()
    }
}

