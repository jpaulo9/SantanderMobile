package com.appn.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.appn.santanderdevweek.R
import com.appn.santanderdevweek.data.Conta
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewmodel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewmodel = ViewModelProvider(this).get(MainViewModel::class.java)
        SelecionarCliente()


    }

    private fun SelecionarCliente(){
        mainViewmodel.buscarContaCliente().observe(this, Observer { result ->
            verDados(result)

        })


    }

    private fun verDados(conta: Conta){

        findViewById<TextView>(R.id.id_agencia).text = conta.agencia
        findViewById<TextView>(R.id.id_conta).text = conta.numero
        findViewById<TextView>(R.id.id_slimite_valor).text = conta.limite
        findViewById<TextView>(R.id.id_saldo_total).text = conta.saldo
        findViewById<TextView>(R.id.id_usuario).text = conta.cliente.nome
        findViewById<TextView>(R.id.pague_final).text = conta.cartao.numeroDaconta

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_dev, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.item_noti -> {
                Log.d("CLICK", "Clicado 1")
                true
            }else -> super.onOptionsItemSelected(item)

        }

    }
}