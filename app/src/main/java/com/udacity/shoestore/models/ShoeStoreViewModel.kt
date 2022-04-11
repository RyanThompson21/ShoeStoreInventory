package com.udacity.shoestore.models

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeStoreViewModel : ViewModel() {
    // list of shoes
    private var _shoeList = MutableLiveData<List<Shoe>>()
    val shoes : LiveData<List<Shoe>>
        get() = _shoeList

    private var shoeList = mutableListOf<Shoe>(
        Shoe("Air", "9.0", "Nike", "bouncey"),
        Shoe("Farout", "8.0", "Nike", "zoom"),
        Shoe("Slippz", "7.0", "Adidas", "comfy")
    )

    init {
        _shoeList.value = shoeList
    }
    fun addShoe(new: Shoe){
        shoeList.add(new)
    }

    fun showShoes():String{
        var ret = ""
        for (item in shoeList.indices) {
            ret = ret.plus(
                "Company: ${shoeList[item].company} \n"+
                        "Name: ${shoeList[item].name} \n"+
                        "Size: ${shoeList[item].size} \n"+
                        "Description: ${shoeList[item].description} \n" +
                        "--------------------------------------- \n")
        }
        return ret
    }
}