package com.kr.datasource.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeProductResponseModel(
    @Json(name = "items")
    var items: List<Item?>? = listOf()
) {

    @JsonClass(generateAdapter = true)
    data class Item(
        @Json(name = "id")
        var id: Int? = 0,

        @Json(name = "name")
        var name: String? = "",

        @Json(name = "price")
        var price: Double? = 0.0,

        @Json(name = "sku")
        var sku: String = ""  ,

        @Json(name = "img_url")
        var imgUrl: String? = "",

//TODO: add any extra info about the product as you need...
    )


}