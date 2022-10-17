package com.kr.categories_datasource.network.dto


import com.kr.categories_domain.model.Categories
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChildrenData(
    @Json(name = "additional_text_color")
    val additionalTextColor: String = "",
    @Json(name = "category_color")
    val categoryColor: String = "",
    @Json(name = "category_icon")
    val categoryIcon: String = "",
    @Json(name = "category_name_text_color")
    val categoryNameTextColor: String = "",
    @Json(name = "children_data")
    val childrenData: List<ChildrenDataX> = listOf(),
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


fun ChildrenData.toCategories(): Categories {
    return Categories(
        name = this.name,
        category_icon = this.categoryIcon,
        category_color = this.categoryColor,
        square_background_image = this.squareBackgroundImage,
        category_name_text_color = this.categoryNameTextColor,
        additional_text_color = this.additionalTextColor


                /*name = this.childrenData.map { it.name }.toString(),
                category_icon = this.childrenData.map { it.categoryIcon }.toString(),
                category_color = this.childrenData.map { it.categoryColor }.toString(),
                square_background_image = this.childrenData.map { it.squareBackgroundImage }.toString(),
                category_name_text_color = this.childrenData.map { it.categoryNameTextColor }.toString(),
                additional_text_color = this.childrenData.map { it.additionalTextColor }.toString(),
*/
                )


}
