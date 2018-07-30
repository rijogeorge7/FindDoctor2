package com.example.data.repository

import com.example.data.DataManagerImpl
import com.example.data.model.DoctorProfile
import com.example.data.model.Language
import com.example.data.webServices.DoctorService
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import javax.inject.Inject


class DoctorsRepositoryImpl @Inject constructor() : DoctorsRepository {
    init {
        DataManagerImpl.dataComponent.inject(this)
    }

    @Inject lateinit var doctorService: DoctorService

    override fun getDoctorsInArea(location: String, skip: Int, limit: Int, specialty_uid: String?, insurance_uid: String?): List<DoctorProfile> {
        var callResponse = doctorService.getDoctors(location,limit,null, null, null, null, null, null, null, null, null, skip)
                var response = callResponse.execute()
        var jsonStr = response.body()
        var doctorProfiles : List<DoctorProfile> = getProfileListFromJson(jsonStr)
        return doctorProfiles
    }

    private fun getProfileListFromJson(jsonStr: String?): List<DoctorProfile> {
        var doctorProfiles = ArrayList<DoctorProfile>()
        var profile = DoctorProfile()
        val dataArray : JsonArray = JsonParser().parse(jsonStr)
                .getAsJsonObject().getAsJsonArray("data")
        for ( data in dataArray) {
            var profileObj = data.asJsonObject.get("profile")
            profile.first_name = profileObj.asJsonObject.get("first_name").asString
            profile.middle_name = profileObj.asJsonObject.get("middle_name")?.asString
            profile.last_name = profileObj.asJsonObject.get("last_name").asString
            profile.slug = profileObj.asJsonObject.get("slug")?.asString
            profile.title = profileObj.asJsonObject.get("title")?.asString
            profile.image_url = profileObj.asJsonObject.get("image_url")?.asString
            profile.gender = profileObj.asJsonObject.get("gender")?.asString
            profile.bio = profileObj.asJsonObject.get("bio")?.asString
            val languagesArray = profileObj.asJsonObject.getAsJsonArray("languages")
            val languages = ArrayList<Language>()
            for(language in languagesArray){
                val languageObj = Language()
                languageObj.name = language.asJsonObject.get("name").asString
                languageObj.code = language.asJsonObject.get("code").asString
                languages.add(languageObj)
            }
            profile.languages = languages
            doctorProfiles.add(profile)
        }


        return doctorProfiles;
    }

}