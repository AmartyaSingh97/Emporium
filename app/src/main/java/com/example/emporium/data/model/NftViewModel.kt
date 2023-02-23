package com.example.emporium.data.model

import androidx.lifecycle.ViewModel
import com.example.emporium.data.NFT

class NftViewModel : ViewModel() {

    private val _nfts = mutableListOf<NFT>()

    val nfts : List<NFT>
        get() = _nfts


    private fun getNfts(){

    }
}