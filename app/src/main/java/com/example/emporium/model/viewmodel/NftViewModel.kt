package com.example.emporium.model.viewmodel

import androidx.lifecycle.ViewModel
import com.example.emporium.model.datamodel.NFT

class NftViewModel : ViewModel() {

    private val _items = mutableListOf<NFT>()

    val NFT : List<NFT>
        get() = _items


    private fun getNfts(){

    }
}