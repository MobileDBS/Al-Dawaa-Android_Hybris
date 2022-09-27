package com.kr.authentication_datasource.network.dto

import com.kr.authentication_domain.model.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponse(
    @Json(name = "activation_code")
    val activationCode: String?,
    @Json(name = "mobile_number")
    val mobileNumber: String?=" ",
    @Json(name = "verification_status")
    val verificationStatus: String?,
    @Json(name = "cart_count")
    val cartCount: Int?,
    @Json(name = "cart_id")
    val cartId: String?,
    @Json(name = "customer")
    var userDto: UserDto?,
    @Json(name = "device_active")
    val deviceActive: Boolean?,
    @Json(name = "firebase_token")
    val firebaseToken: String?,
    @Json(name = "token")
    val token: String?,
    @Json(name = "code")
    val code: Int?=null,
    @Json(name = "message")
    val message: String?=null,

    ) {
    @JsonClass(generateAdapter = true)
    data class UserDto(
        @Json(name = "addresses")
        val addresses: List<Address?>?,
        @Json(name = "created_at")
        val createdAt: String?,
        @Json(name = "created_in")
        val createdIn: String?,
        @Json(name = "custom_attributes")
        val customAttributes: List<CustomAttribute?>?,
        @Json(name = "default_billing")
        val defaultBilling: String?,
        @Json(name = "default_shipping")
        val defaultShipping: String?,
        @Json(name = "disable_auto_group_change")
        val disableAutoGroupChange: Int?,
        @Json(name = "email")
        val email: String?,
        @Json(name = "extension_attributes")
        val extensionAttributes: ExtensionAttributes?,
        @Json(name = "firstname")
        val firstname: String?,
        @Json(name = "group_id")
        val groupId: Int?,
        @Json(name = "id")
        val id: Int?,
        @Json(name = "lastname")
        val lastname: String?,
        @Json(name = "store_id")
        val storeId: Int?,
        @Json(name = "updated_at")
        val updatedAt: String?,
        @Json(name = "website_id")
        val websiteId: Int? ,
        @Json(name = "gender")
        val gender: Int?
    ) {


        @JsonClass(generateAdapter = true)
        data class Address(
            @Json(name = "city")
            val city: String?,
            @Json(name = "country_id")
            val countryId: String?,
            @Json(name = "custom_attributes")
            val customAttributes: List<CustomAttribute?>?,
            @Json(name = "customer_id")
            val customerId: Int?,
            @Json(name = "default_billing")
            val defaultBilling: Boolean?,
            @Json(name = "default_shipping")
            val defaultShipping: Boolean?,
            @Json(name = "extension_attributes")
            val extensionAttributes: ExtensionAttributes?,
            @Json(name = "firstname")
            val firstname: String?,
            @Json(name = "id")
            val id: Int?,
            @Json(name = "lastname")
            val lastname: String?,
            @Json(name = "postcode")
            val postcode: String?,
            @Json(name = "region")
            val region: Region?,
            @Json(name = "region_id")
            val regionId: Int?,
            @Json(name = "street")
            val street: List<String?>?,
            @Json(name = "telephone")
            val telephone: String?
        ) {
            @JsonClass(generateAdapter = true)
            data class CustomAttribute(
                @Json(name = "attribute_code")
                val attributeCode: String?,
                @Json(name = "value")
                val value: String?
            )

            @JsonClass(generateAdapter = true)
            data class ExtensionAttributes(
                @Json(name = "is_default_billing")
                val isDefaultBilling: Boolean?,
                @Json(name = "is_default_shipping")
                val isDefaultShipping: Boolean?
            )
            @JsonClass(generateAdapter = true)
            data class Region(
                @Json(name = "region")
                val region: String?,
                @Json(name = "region_code")
                val regionCode: String?,
                @Json(name = "region_id")
                val regionId: Int?
            )
        }

        @JsonClass(generateAdapter = true)
        data class CustomAttribute(
            @Json(name = "attribute_code")
            val attributeCode: String?,
            @Json(name = "value")
            val value: String?
        )

        @JsonClass(generateAdapter = true)
        data class ExtensionAttributes(
            @Json(name = "is_subscribed")
            val isSubscribed: Boolean?,
            @Json(name = "gender_label")
            val genderLabel: String?
        )
    }
}
fun LoginResponse.toUser(): User {
    return User(
        id = this.userDto?.id,
        email = this.userDto?.email,
        firstname = this.userDto?.firstname,
        lastname = this.userDto?.lastname,
        gender = this.userDto?.gender,
        phone = this.mobileNumber

    )}