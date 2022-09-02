package com.terranullius.tamshaemployees.di

import com.terranullius.tamshaemployees.api.TamashaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(TamashaApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}