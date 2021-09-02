package com.bongamnguni.weatherservices.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.bongamnguni.weatherservices.database.CurrentWeather
import com.bongamnguni.weatherservices.database.FavoriteModel
import com.bongamnguni.weatherservices.database.Forecast
import com.bongamnguni.weatherservices.database.ForecastDatabase
import kotlinx.coroutines.launch


open class ForecastViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ForecastRepository

    init {
        val forecastDao = ForecastDatabase
            .getDatabase(application, viewModelScope)
            .forestDao()
        repository = ForecastRepository(forecastDao)
    }

    fun getForecast(): LiveData<List<Forecast>> {
        return repository.getForecast()
    }
    fun getCurrent(): LiveData<List<CurrentWeather>> {
        return repository.getCurrent()
    }
    fun getFavorite(): LiveData<List<FavoriteModel>> {
        return repository.getFavorite()
    }
    fun insertForecast(forecast: Forecast) = viewModelScope.launch {
        repository.insertForecast(forecast)
    }
    fun insertCurrent(currentWeather: CurrentWeather) = viewModelScope.launch {
        repository.insertCurrentWeather(currentWeather)
    }
    fun insertFavorite(favoriteModel: FavoriteModel) = viewModelScope.launch {
        repository.insertFavorite(favoriteModel)
    }

}