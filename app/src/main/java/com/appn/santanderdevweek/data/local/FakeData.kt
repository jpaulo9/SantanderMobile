package com.appn.santanderdevweek.data.local

import com.appn.santanderdevweek.data.Cartao
import com.appn.santanderdevweek.data.Cliente
import com.appn.santanderdevweek.data.Conta

 class FakeData {

    fun getLocaData(): Conta {

        val cliente = Cliente("Jpaulo")
        val cartao = Cartao("324728782")
        return Conta (
        "308439-9",
        "273-3",
         "2.450,30",
        "8.340,90",
         cliente,
         cartao
        );


    }
}