package com.bongamnguni.weatherservices.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.bongamnguni.weatherservices.database.CurrentWeather
import com.bongamnguni.weatherservices.database.FavoriteModel
import com.bongamnguni.weatherservices.database.Forecast
import com.bongamnguni.weatherservices.database.ForecastDao


class ForecastRepository(private val forecastDao: ForecastDao) {

    fun getForecast(): LiveData<List<Forecast>> {
        return forecastDao.getAllForecast()
    }
    fun getCurrent(): LiveData<List<CurrentWeather>> {
        return forecastDao.getCurrent()
    }
    fun getFavorite(): LiveData<List<FavoriteModel>> {
        return forecastDao.getAllFavorite()
    }
    suspend fun insertForecast(forecast: Forecast) {
        forecastDao.insertAllForecast(forecast)
    }
    suspend fun insertCurrentWeather(currentWeather: CurrentWeather){
        forecastDao.insertCurrentWeather(currentWeather)
    }
    suspend fun insertFavorite(favoriteModel: FavoriteModel){
        forecastDao.insertFavorite(favoriteModel)
    }
    fun DeleteAll(forecastDao: ForecastDao) {

        forecastDao.deleteAll()
        forecastDao.deleteAllCurrent()

        Log.d("DeletedAllData", "prePopulateDatabase: ")
    }




}