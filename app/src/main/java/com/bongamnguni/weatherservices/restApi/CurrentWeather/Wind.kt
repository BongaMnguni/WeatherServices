package com.bongamnguni.weatherservices.restApi.CurrentWeather


import com.google.gson.annotations.SerializedName

data class Wind(
    val deg: Int,
    val speed: Double
)