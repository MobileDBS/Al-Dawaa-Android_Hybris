package com.kr.categories_datasource.network


import com.kr.categories_datasource.network.dto.categoriesResponse
import javax.inject.Inject

class CategoriesRepoImp @Inject constructor(private val apiInterface: CategoriesApiInterface) {

    suspend fun getcategories(): categoriesResponse {
        return apiInterface.getcategories(
            "english"
        )
    }
}


