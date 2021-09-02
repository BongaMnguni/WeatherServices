package com.bongamnguni.weatherservices.restApi

import androidx.lifecycle.LiveData
import com.bongamnguni.weatherservices.restApi.CurrentWeather.CurrentWeatherResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object CurrentWeatherRepository {
    var job:CompletableJob? = null
    fun getUser(city:String):LiveData<CurrentWeatherResponse>{
   job= Job()
        return object : LiveData<CurrentWeatherResponse>(){
            override fun onActive() {
                super.onActive()
                job?.let {theJob->
                    CoroutineScope( IO + theJob ).launch {
                        val weather = WeatherRetrofitBuilder.apiService.getCurrent(city)
                        withContext(Main){
                            value = weather
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun cancelJobs(){
        job?.cancel()
    }


}
