package com.example.emporium.model.viewmodel

import androidx.lifecycle.ViewModel
import com.example.emporium.model.datamodel.NFT

class NftViewModel : ViewModel() {

    private val _nfts = mutableListOf<NFT>()

    val nfts : List<NFT>
        get() = _nfts


    private fun getNfts(){

    }
}