package com.kr.product_datasource.dto

data class Filter(
val filter: List<Filteritems>

)

data class Filteritems(
    val filteritemsname: List<String> = listOf(
"items of Filter categories",
"items of Filter brand",
"items of Filter price",
        ),
    val filtersub : List<Filtersub>
    )

data class Filtersub(
    val filtersubname: List<String>,
    val filtersubbolean : List<Boolean>
)