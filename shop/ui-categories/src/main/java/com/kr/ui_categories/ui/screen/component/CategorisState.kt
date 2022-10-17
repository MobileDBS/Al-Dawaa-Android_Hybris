package com.kr.ui_categories.ui.screen.component

import com.kr.categories_datasource.network.dto.ChildrenData
import com.kr.categories_datasource.network.dto.categoriesResponse
import com.kr.categories_domain.model.Categories

//import com.kr.categories_domain.model.Categories


data class CategorisState(
    val isLoading: Boolean = false,
    val Categorieslist: List<Categories> = emptyList(),
    val error: String = ""
)
