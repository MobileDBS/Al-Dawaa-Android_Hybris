package com.kr.categories_interactors.usecase

import com.kr.categories_datasource.network.CategoriesRepoImp
import com.kr.categories_datasource.network.dto.ChildrenData
import com.kr.categories_datasource.network.dto.categoriesResponse
import com.kr.categories_datasource.network.dto.toCategories
import com.kr.categories_domain.model.Categories
import com.kr.core.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CategoriesUseCase @Inject constructor(
    private  val categoriesrepository: CategoriesRepoImp
) {
   operator fun invoke(): Flow<Resource<List<Categories>>> = flow {
        try {
            emit(Resource.Loading())
            val response = categoriesrepository.getcategories().childrenData.map { it.toCategories() }
            emit(Resource.Success<List<Categories>>(response))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection."))
        }
    }
}