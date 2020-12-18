package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_historico_customizada.*

class HistoricoActivityCustomizada : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico_customizada)

        val listaCalculos = intent.getParcelableExtra<HistoricoCalculos>("testeObjeto")?.listaCalculos


        if(listaCalculos != null) {
            lvHistoricoCustomizada.adapter = CalculosAdapter(this, listaCalculos)
        }
    }
}