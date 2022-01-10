package com.ortudev.sportsResults.di

import android.content.Context
import com.ortudev.sportsResults.data.db.F1Database
import com.ortudev.sportsResults.data.db.LocalDataSource
import com.ortudev.sportsResults.data.db.RoomDataSource
import com.ortudev.sportsResults.data.domain.F1Repository
import com.ortudev.sportsResults.data.server.api.F1Api
import com.ortudev.sportsResults.data.server.RemoteClient
import com.ortudev.sportsResults.data.server.RemoteDataSource
import com.ortudev.sportsResults.data.server.ServerDataSource
import com.ortudev.sportsResults.ui.detail.DetailViewModel
import com.ortudev.sportsResults.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val appModule = module {
}

val repositoryModule = module{
    factory { F1Repository(get(),get()) }
    single { provideLocalDataSource(get()) }
    single { provideRemoteDataSource(get()) }
    single { provideLocalDatabase(get()) }
    single { provideF1API() }
}
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}

fun provideRemoteDataSource(f1Api: F1Api):RemoteDataSource{
    return ServerDataSource(f1Api)
}
fun provideLocalDataSource(db:F1Database):LocalDataSource{
    return RoomDataSource(db)
}
fun provideLocalDatabase(context: Context):F1Database =
    F1Database.getInstance(context)


fun provideF1API(): F1Api {
    return RemoteClient.buildApi(F1Api::class.java)
}
