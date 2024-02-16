package uz.pixelgame.mymarketplace.di.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.pixelgame.mymarketplace.data.network.ApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MyService {

    @[Provides Singleton]
    fun provideHomeService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}