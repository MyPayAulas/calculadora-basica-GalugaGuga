package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_historico_recycler.*

class HistoricoRecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico_recycler)

        val historico = intent.getParcelableExtra<HistoricoCalculos>("historico")


        if(historico != null) {
            rvHistorico.layoutManager = LinearLayoutManager(this)
            rvHistorico.adapter = HistoricoRecyclerAdapter(this, historico.listaCalculos, ::onItemClick)
            rvHistorico.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        }
    }

    private fun onItemClick(expressao: String){
        Toast.makeText(this, expressao, Toast.LENGTH_SHORT).show()
    }
}