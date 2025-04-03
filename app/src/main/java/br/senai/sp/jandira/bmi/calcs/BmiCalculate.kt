package br.senai.sp.jandira.bmi.calcs

import androidx.compose.ui.graphics.Color
import br.senai.sp.jandira.bmi.model.Bmi
import br.senai.sp.jandira.bmi.model.BmiStatus
import kotlin.math.pow

fun bmiCalculate(weight: Int, height: Double): Bmi{
    //    val bmiResult = weight.div(height.pow(2))
    //    val bmiResult = weight / (height * height)
    val bmiResult = weight / height.pow(2)

    when{
        bmiResult < 18.5 ->
            return Bmi(
                bmi = Pair("", bmiResult),
                bmiColor = Color(0xFF00BCD4),
                bmiStatus = BmiStatus.UNDER_WEIGHT
            )
        bmiResult >= 18.5 && bmiResult < 25.0->
            return Bmi(
                bmi = Pair("", bmiResult),
                bmiColor = Color(0xFF0DE812),
                bmiStatus = BmiStatus.NORMAL
            )
        bmiResult >= 25.0 && bmiResult < 30.0->
            return Bmi(
                bmi = Pair("", bmiResult),
                bmiColor = Color(0xFFA2C444),
                bmiStatus = BmiStatus.OVER_WEIGHT
            )
        bmiResult >= 30.0 && bmiResult < 35->
            return Bmi(
                bmi = Pair("", bmiResult),
                bmiColor = Color(0xFFFF9800),
                bmiStatus = BmiStatus.OBESITY_1
            )
        bmiResult >= 35.0 && bmiResult < 40.0->
            return Bmi(
                bmi = Pair("", bmiResult),
                bmiColor = Color(0xFFFF5722),
                bmiStatus = BmiStatus.OBESITY_2
            )

        else ->
            return Bmi(
                bmi = Pair("", bmiResult),
                bmiColor = Color(0xFFFF000B),
                bmiStatus = BmiStatus.OBESITY_3
            )
    }
}