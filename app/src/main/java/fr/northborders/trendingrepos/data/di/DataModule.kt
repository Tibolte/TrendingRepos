package fr.northborders.trendingrepos.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import fr.northborders.trendingrepos.data.data.ApiGithubDataSource
import fr.northborders.trendingrepos.data.data.GithubService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {
    val ENDPOINT = "https://api.github.com/"

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesGithubService(retrofit: Retrofit): GithubService =
        retrofit.create(GithubService::class.java)

    @Provides
    @Singleton
    fun providesApiGithubDataSource(githubService: GithubService): ApiGithubDataSource =
        ApiGithubDataSource(githubService)
}
