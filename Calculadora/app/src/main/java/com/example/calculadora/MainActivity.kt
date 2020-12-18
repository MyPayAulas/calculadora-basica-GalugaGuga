package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_historico.*
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

            historico.setOnClickListener {
                val intent = Intent(this, HistoricoActivityCustomizada::class.java)
                intent.putExtra("testeVarString", "Historico")
                intent.putExtra("testeVarInteiro", 55)

                val historico = HistoricoCalculos(mutableListOf(Calculo("1+1","2")))
                intent.putExtra("testeObjeto", historico)
                startActivity(intent)
            }

        zero.setOnClickListener { addExp("0",true) }
        one.setOnClickListener { addExp("1",true) }
        two.setOnClickListener { addExp("2",true) }
        three.setOnClickListener { addExp("3",true) }
        four.setOnClickListener { addExp("4",true) }
        five.setOnClickListener { addExp("5",true) }
        six.setOnClickListener { addExp("6",true) }
        seven.setOnClickListener { addExp("7",true) }
        eight.setOnClickListener { addExp("8",true) }
        nine.setOnClickListener { addExp("9",true) }
        comma.setOnClickListener { addExp(".",true) }
        parentheses.setOnClickListener { addExp("( )",true) }

        add.setOnClickListener { addExp("+",false) }
        subtract.setOnClickListener { addExp("-",false) }
        multiply.setOnClickListener { addExp("*",false) }
        plusMinus.setOnClickListener { addExp("-",false) }
        exponent.setOnClickListener { addExp("^",false) }
        divide.setOnClickListener { addExp("/",false) }
        clear.setOnClickListener{
            expressao.text = ""
            txt_resultado.text = ""

        }
        backspace.setOnClickListener {
            val string = expressao.text.toString()
            if (string.isNotBlank())expressao.text = string.substring(0,string.length-1)
            }

            equals.text = ""

        equals.setOnClickListener {
            try {
                val expressao = ExpressionBuilder(expressao.text.toString()).build()

                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()

                if(resultado == longResult.toDouble())
                    txt_resultado.text = longResult.toString()
                else
                    txt_resultado.text = resultado.toString()



            }catch (e: Exception){

            }
        }
    }

        private fun addExp(string: String, clearData: Boolean) {

        if(txt_resultado.text.isNotEmpty()) {
            expressao.text = ""
        }

        if(clearData){
            txt_resultado.text = ""
            expressao.append(string)

        }else{
            expressao.append(txt_resultado.text)
            expressao.append(string)
            txt_resultado.text = ""
        }
    }

}