package com.bongamnguni.weatherservices.restApi

import androidx.lifecycle.LiveData
import com.bongamnguni.weatherservices.restApi.ForecastWeather.ForecastModel
import kotlinx.coroutines.*

object ForecastWeatherRepository {

    var job: CompletableJob? = null
    fun getUser(user_id:String): LiveData<ForecastModel> {
        job= Job()
        return object : LiveData<ForecastModel>(){
            override fun onActive() {
                super.onActive()
                job?.let {theJob->
                    CoroutineScope( Dispatchers.IO + theJob ).launch {
                        val weather = WeatherRetrofitBuilder.apiService.getForecast(user_id)
                        withContext(Dispatchers.Main){
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