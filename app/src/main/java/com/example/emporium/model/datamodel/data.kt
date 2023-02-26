package com.example.emporium.model.datamodel

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class NFT(
    var id: String,
    var name: String,
    var description: String,
    var imageUrl: String,
    var price: String,
    var owner: String,
    var category: String,
    var createdDate: String,
    var origin: String,
    var rating: String
)

@JsonClass(generateAdapter = true)
data class Response(
    @field:Json(name="data") val data: ResponseData
)

@JsonClass(generateAdapter = true)
data class ResponseData(
    @field:Json(name="nftModels") val nftModels: Items
)

@JsonClass(generateAdapter = true)
data class Items(
    @field:Json(name="items") val items: List<Item>
)

@JsonClass(generateAdapter = true)
data class Item(
    @field:Json(name="id") val id: String,
    @field:Json(name="title") val title: String,
    @field:Json(name="description") val description: String,
    @field:Json(name="quantity") val quantity: Int,
    @field:Json(name="quantityMinted") val quantityMinted: Int,
    @field:Json(name="nfts") val nfts: List<Any>,
    @field:Json(name="status") val status: String,
    @field:Json(name="rarity") val rarity: String,
    @field:Json(name="content") val content: Content,
)

@JsonClass(generateAdapter = true)
data class Content(
    @field:Json(name="files") val files: List<com.example.emporium.model.datamodel.File>,
    @field:Json(name="poster") val url: com.example.emporium.model.datamodel.Url,
)

@JsonClass(generateAdapter = true)
data class File(
    @field:Json(name="url") val url: String,
    @field:Json(name="contentType") val contentType: String,
)

@JsonClass(generateAdapter = true)
data class Url(
    @field:Json(name="url") val url: String,)





