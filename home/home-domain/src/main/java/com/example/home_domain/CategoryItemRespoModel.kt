package com.kr.home_datasource.dto



data class CategoryItemRespoModel (
   // @Json(name = "name")
    var categoryType: String? = "",
    var headerDataList: List<HeaderData?>? = listOf(),
   // var productList:List<ProductListModel?>?= listOf(),
    var topBrandImage:List<String?>?= listOf(),
    var categoriesList:List<Categories?>?= listOf()
) {



}
data class HeaderData(
    var backGroundColor: Int? = 0,
    var imageBackGroundColor: Int? = 0,
    var imageUrl: String? = "",
    var promotionHeadline: String? = "",
    var promotionDescription: String? = "",
)
data class Categories(
    val image:String?="",
    val name:String?=""
)