package com.bongamnguni.weatherservices.restApi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.bongamnguni.weatherservices.restApi.CurrentWeather.CurrentWeatherResponse

class WeatherViewModel : ViewModel()
{
    private val _current: MutableLiveData<String> = MutableLiveData()
    val currentWeather: LiveData<CurrentWeatherResponse> = Transformations
        .switchMap(_current){
           CurrentWeatherRepository.getUser(it)
        }
    fun setCurrentCity(place: String){
        val update = place
        if(_current.value == update){
            return
        }
        _current.value = update
    }
    fun cancelJobs (){
        CurrentWeatherRepository.cancelJobs()
    }
}