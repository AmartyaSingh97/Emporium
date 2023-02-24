package com.example.emporium.data.viewmodel

import androidx.lifecycle.ViewModel
import com.example.emporium.data.datamodel.NFT

class NftViewModel : ViewModel() {

    private val _nfts = mutableListOf<NFT>()

    val nfts : List<NFT>
        get() = _nfts


    private fun getNfts(){

    }
}