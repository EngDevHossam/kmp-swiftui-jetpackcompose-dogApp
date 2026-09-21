package com.hossam.dogify.di

import com.hossam.dogify.api.BreedsApi
import com.hossam.dogify.database.createDriver
import com.hossam.dogify.db.DogifyDatabase
import com.hossam.dogify.repository.*
import com.hossam.dogify.repository.DefaultBreedsLocalSource
import com.hossam.dogify.repository.DefaultBreedsRemoteSource
import com.hossam.dogify.usecase.FetchBreedsUseCase
import com.hossam.dogify.usecase.GetBreedsUseCase
import com.hossam.dogify.usecase.ToggleFavouriteStateUseCase
import com.hossam.dogify.util.getDispatcherProvider
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

private val utilityModule = module {
    factory { getDispatcherProvider() }
    single { DogifyDatabase(createDriver("dogify.db")) }
}

private val apiModule = module {
    factory { BreedsApi() }
}

private val repositoryModule = module {
    single { BreedsRepository() }

    factory<BreedsRemoteSource> { DefaultBreedsRemoteSource(get(), get()) }
    factory<BreedsLocalSource> { DefaultBreedsLocalSource(get(), get()) }
}

private val usecaseModule = module {
    factory { GetBreedsUseCase() }
    factory { FetchBreedsUseCase() }
    factory { ToggleFavouriteStateUseCase() }
}

private val sharedModules = listOf(usecaseModule, repositoryModule, apiModule, utilityModule)

fun initKoin(appDeclaration: KoinAppDeclaration) = startKoin {
    modules(sharedModules)
    appDeclaration()
}

fun initKoin() = initKoin { }