package com.appn.santanderdevweek.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appn.santanderdevweek.data.Conta
import com.appn.santanderdevweek.data.local.FakeData

class MainViewModel : ViewModel() {

    private val mutableData: MutableLiveData<Conta> = MutableLiveData()

    fun buscarContaCliente () : LiveData<Conta> {

        mutableData.value = FakeData().getLocaData();

        return mutableData

    }

}