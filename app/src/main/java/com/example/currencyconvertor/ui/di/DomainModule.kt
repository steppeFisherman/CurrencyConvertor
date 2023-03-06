package com.example.currencyconvertor.ui.di

import com.example.currencyconvertor.domain.FetchUseCase
import com.example.currencyconvertor.domain.Repository
import com.example.currencyconvertor.ui.model.MapDomainToUi
import com.example.currencyconvertor.utils.ToDispatch
import dagger.Module
import dagger.Provides

import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideFetchUseCase(repository: Repository): FetchUseCase =
        FetchUseCase.Base(repository = repository)

    @Provides
    fun provideMapDomainToUi(): MapDomainToUi = MapDomainToUi.Base()

    @Provides
    fun provideDispatchers(): ToDispatch = ToDispatch.Base()
}