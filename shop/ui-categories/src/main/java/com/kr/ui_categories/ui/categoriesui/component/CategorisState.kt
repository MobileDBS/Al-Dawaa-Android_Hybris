package com.kr.ui_categories.ui.categoriesui.component

import com.kr.categories_domain.model.Categories

//import com.kr.categories_domain.model.Categories


data class CategorisState(
    val isLoading: Boolean = false,
    val Categorieslist: List<Categories> = emptyList(),
    val error: String = ""
)
