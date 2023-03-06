package com.example.currencyconvertor.ui.di

import android.app.Application
import com.example.currencyconvertor.data.model.MapCloud
import com.example.currencyconvertor.data.net.CloudData
import com.example.currencyconvertor.data.net.MyService
import com.example.currencyconvertor.data.repository.CloudSource
import com.example.currencyconvertor.data.repository.ExceptionHandle
import com.example.currencyconvertor.data.repository.RepositoryImpl
import com.example.currencyconvertor.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(MyService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): MyService = retrofit.create(MyService::class.java)

    @Provides
    @Singleton
    fun provideCloud(myService: MyService): CloudData = CloudData.Base(myService)

    @Provides
    fun provideExceptionHandle(): ExceptionHandle = ExceptionHandle.Base()

    @Provides
    @Singleton
    fun provideMapCloudToDomain(context: Application): MapCloud =
        MapCloud.Base(context)

    @Provides
    fun provideCloudSource(
        cloudData: CloudData,
        mapper: MapCloud
    ): CloudSource = CloudSource.Base(
        cloudData = cloudData,
        mapper = mapper
    )

    @Provides
    @Singleton
    fun provideRepository(
        cloudSource: CloudSource,
        exceptionHandle: ExceptionHandle,
    ): Repository = RepositoryImpl(
        cloudSource = cloudSource,
        exceptionHandle = exceptionHandle,
    )
}