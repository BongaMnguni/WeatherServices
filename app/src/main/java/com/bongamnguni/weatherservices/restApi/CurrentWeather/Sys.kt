package com.bongamnguni.weatherservices.restApi.CurrentWeather


data class Sys(
    val country: String,
    val id: Int,
    val message: Double,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)