package com.example.calculadora

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class Calculo (val expressao: String, val resultado: String): Parcelable{
    override fun toString(): String {
        return "$expressao = $resultado"
    }
}