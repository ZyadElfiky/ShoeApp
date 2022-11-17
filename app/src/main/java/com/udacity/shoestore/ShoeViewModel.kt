package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    var shoe=Shoe("", 0.0,"","")
    private var _shoesList = MutableLiveData<ArrayList<Shoe>>()
    val shoesList:LiveData<ArrayList<Shoe>> get() = _shoesList
    var shoesArrayList = ArrayList<Shoe>()


    fun addNewShoe() {

        shoesArrayList.add(shoe)
        _shoesList.value = shoesArrayList
        shoe=Shoe("",0.0,"","")

    }


}