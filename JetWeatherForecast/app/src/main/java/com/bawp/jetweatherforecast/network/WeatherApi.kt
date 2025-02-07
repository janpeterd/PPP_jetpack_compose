package com.bawp.jetweatherforecast.network

import com.bawp.jetweatherforecast.model.Weather
import com.bawp.jetweatherforecast.utils.Constants.API_KEY
import javax.inject.Singleton
import retrofit2.http.GET
import retrofit2.http.Query

@Singleton
interface WeatherApi {
  @GET(value = "data/2.5/forecast/daily")
  suspend fun getWeather(
      @Query("q") query: String,
      @Query("units") units: String = "imperial",
      @Query("appid") appid: String = API_KEY // your api key
  ): Weather
}

