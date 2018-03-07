package fr.northborders.trendingrepos.data.remote

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface MarkdownService {
    @Headers("Content-Type: text/plain")
    @POST("markdown/raw")
    fun markdown(@Body readme: String): Single<String>
}