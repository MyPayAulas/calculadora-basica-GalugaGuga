package com.example.calculadora

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CalculosAdapter(val context: Context, val calculos:  MutableList<Calculo>) : BaseAdapter() {
    override fun getCount(): Int {
        return calculos.size
    }

    override fun getItem(position: Int): Any {
        return calculos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_calculo,
            parent,
            false,
        )
        val textView_Id = view.findViewById<TextView>(R.id.txtIdCalculo)
        val textView_Equacao = view.findViewById<TextView>(R.id.txtExpressao)
        val calculo = calculos[position]
        textView_Id.text = position.toString()
        textView_Equacao.text = calculo.toString()
        return view
    }

}
