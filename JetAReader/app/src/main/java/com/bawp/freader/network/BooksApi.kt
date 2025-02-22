package com.bawp.freader.network

import com.bawp.freader.model.Book
import com.bawp.freader.model.Item
import javax.inject.Singleton
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

@Singleton
interface BooksApi {

  @GET("volumes") suspend fun getAllBooks(@Query("q") query: String): Book

  @GET("volumes/{bookId}") suspend fun getBookInfo(@Path("bookId") bookId: String): Item
}

