package com.kr.categories_datasource.network.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChildrenDataX(
    @Json(name = "additional_text_color")
    val additionalTextColor: String = "",
    @Json(name = "category_color")
    val categoryColor: String = "",
    @Json(name = "category_icon")
    val categoryIcon: String = "",
    @Json(name = "category_name_text_color")
    val categoryNameTextColor: String = "",
    @Json(name = "children_data")
    val childrenData: List<Any> = listOf(),
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "image")
    val image: String = "",
    @Json(name = "include_in_menu")
    val includeInMenu: String = "",
    @Json(name = "is_active")
    val isActive: Boolean = false,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "parent_id")
    val parentId: Int = 0,
    @Json(name = "position")
    val position: Int = 0,
    @Json(name = "product_count")
    val productCount: Int = 0,
    @Json(name = "rectangle_background_image")
    val rectangleBackgroundImage: String = "",
    @Json(name = "square_background_image")
    val squareBackgroundImage: String = ""
)