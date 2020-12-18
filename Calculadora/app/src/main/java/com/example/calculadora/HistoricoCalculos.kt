package com.example.calculadora

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class HistoricoCalculos (var listaCalculos: MutableList<Calculo>): Parcelable