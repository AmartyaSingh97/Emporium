package com.example.emporium.data.datamodel

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
