package com.kr.categories_datasource.network

import com.kr.categories_datasource.network.dto.categoriesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoriesApiInterface {
    //categories
    @GET("{lang}/V1/crocoit/categories?rootCategoryId=2&depth=2")
    suspend fun getcategories(
        @Path("lang") lang: String
    ): categoriesResponse

}