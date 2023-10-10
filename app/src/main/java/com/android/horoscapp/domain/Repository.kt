package com.android.horoscapp.domain

import com.android.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String):PredictionModel?
}