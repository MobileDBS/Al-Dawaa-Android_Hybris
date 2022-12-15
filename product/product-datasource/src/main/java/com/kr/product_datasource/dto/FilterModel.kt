package com.kr.product_datasource.dto

data class FilterModel(
    val filterrow: List<String> = listOf(),
    val filter: List<Filteritems> = listOf()

) {
    data class Filteritems(
        val Filteritemsname: String="" ,
        val filteritemsub: List<Filtersub> = listOf(),

    ) {
        data class Filtersub(
            val key :String,
            val filtersubname:String,
            val filtersubbolean: Boolean
        )
    }
}