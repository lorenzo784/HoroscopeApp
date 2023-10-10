package com.android.horoscapp.data

import android.util.Log
import com.android.horoscapp.data.network.HoroscopeApiService
import com.android.horoscapp.data.network.response.PredictionResponse
import com.android.horoscapp.domain.Repository
import com.android.horoscapp.domain.model.PredictionModel
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {

    override suspend fun getPrediction(sign: String):PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("lorenzo", "Ha ocurrido un error ${it.message}") }
        return null
    }
}