package fr.northborders.trendingrepos.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import fr.northborders.trendingrepos.data.remote.ApiGithubDataSource
import fr.northborders.trendingrepos.data.remote.GithubService
import fr.northborders.trendingrepos.data.remote.MarkdownService
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import javax.inject.Singleton


@Module
class DataModule {
    val ENDPOINT = "https://api.github.com/"

    class StringConverterFactory: Converter.Factory() {

        val MEDIA_TYPE = "text/plain".toMediaTypeOrNull()

        override fun responseBodyConverter(
            type: Type,
            annotations: Array<Annotation>,
            retrofit: Retrofit
        ): Converter<ResponseBody, *>? {
            return if (String::class.java == type) {
                Converter { value -> value.string() }
            } else null
        }

        override fun requestBodyConverter(
            type: Type,
            parameterAnnotations: Array<Annotation>,
            methodAnnotations: Array<Annotation>,
            retrofit: Retrofit
        ): Converter<*, RequestBody>? {
            return if (String::class.java == type) {
                Converter<String?, RequestBody> { value -> value.toRequestBody(MEDIA_TYPE) }
            } else null
        }
    }

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient.Builder =
        OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient.Builder): Retrofit =
        Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient.build())
            .build()

    @Provides
    @Singleton
    fun providesGithubService(retrofit: Retrofit): GithubService =
        retrofit.create(GithubService::class.java)

    @Provides
    @Singleton
    fun providesMarkdownService(okHttpClient: OkHttpClient.Builder): MarkdownService {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(StringConverterFactory())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient.build())
            .build()

        return retrofitBuilder.create(MarkdownService::class.java)
    }

    @Provides
    @Singleton
    fun providesApiGithubDataSource(githubService: GithubService, markdownService: MarkdownService): ApiGithubDataSource =
        ApiGithubDataSource(githubService, markdownService)
}