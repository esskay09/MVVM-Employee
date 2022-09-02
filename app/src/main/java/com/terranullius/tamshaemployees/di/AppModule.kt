package com.terranullius.tamshaemployees.di

import android.app.Application
import androidx.room.Room
import com.terranullius.tamshaemployees.api.EmployeeApi
import com.terranullius.tamshaemployees.db.EmployeeDatabase
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
        .baseUrl(EmployeeApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideTamashaApi(retrofit: Retrofit): EmployeeApi =
        retrofit.create(EmployeeApi::class.java)

    @Provides
    @Singleton
    fun providesDatabase(app: Application): EmployeeDatabase =
        Room.databaseBuilder(
            app,
            EmployeeDatabase::class.java,
            "employee_db"
        ).build()

    @Provides
    @Singleton
    fun provideEmployeeDao(db: EmployeeDatabase) = db.employeeDao()
}