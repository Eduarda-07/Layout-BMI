package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.bmiCalculate
import br.senai.sp.jandira.bmi.model.Bmi
import br.senai.sp.jandira.bmi.model.BmiStatus
import br.senai.sp.jandira.bmi.screens.components.BmiLevel

import br.senai.sp.jandira.bmi.utils.isFilled
import br.senai.sp.jandira.bmi.utils.numberFormat
import java.util.Locale

@Composable

fun ResultScreen(navegacao: NavHostController?){
    val contexto =  LocalContext.current
    val userFile = contexto
        .getSharedPreferences("userFile", Context.MODE_PRIVATE)
    
    val userAge = userFile.getInt("age", 0)
    val userWeight = userFile.getInt("weight", 0)
    //usar o F para dizer que é float
    val userHeight= userFile.getFloat("height", 0.0F)

    val bmi = bmiCalculate(userWeight, userHeight.toDouble().div(100))



    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF673AB7),
                        Color(0xFF873494),
                        Color(0xFFD53368)
                    )
                )

            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 70.dp, start = 20.dp),
        ) {
            Text(
                text = stringResource(
                    R.string.result
                ),
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Card (
            modifier =  Modifier
                .fillMaxSize()
                .padding(top = 160.dp),
            shape = RoundedCornerShape(
                topStart = 48.dp,
                topEnd = 48.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )

        ){
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Card(
                    modifier = Modifier
                            .size(150.dp),
                    shape =  CircleShape,
                    border = BorderStroke(10.dp, color = bmi.bmiColor)
                ) {
                    Text(
                        text = String.format(
                            Locale.getDefault(),
                            "%.1f",
                            bmi.bmi.second),
                        color = Color.Black,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 60.dp, start = 45.dp)
                    )
                }
                Text(
                    text = bmi.bmi.first,
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier
                        .padding(top = 20.dp)

                )
               Card (
                   shape = RoundedCornerShape(
                    15.dp
                   ),
                   modifier = Modifier
                       .padding(bottom = 20.dp, top = 20.dp)
               ){
                   Row(
                       modifier = Modifier
                           .background(
                               color = Color(0xFFEEDCFA)
                           )
                           .padding(6.dp)
                   ) {
                       Column(
                           modifier = Modifier
                               .weight(1f),
                           horizontalAlignment = Alignment.CenterHorizontally,
                       ) {
                           Text(
                               text = stringResource(
                                   R.string.age
                               ),
                               color = Color(0xFF4F4F4F),
                               fontSize = 22.sp
                           )
                           Text(
                               text = "$userAge",
                               color = Color.Black,
                               fontSize = 25.sp,
                               fontWeight = FontWeight.W500
                           )

                       }

                       VerticalDivider(
                           modifier = Modifier
                               .height(60.dp),
                           color = Color.Gray
                       )

                       Column(
                           modifier = Modifier
                               .weight(1f),
                           horizontalAlignment = Alignment.CenterHorizontally
                       ) {
                           Text(
                               text = stringResource(
                                   R.string.weight
                               ),
                               color = Color(0xFF4F4F4F),
                               fontSize = 22.sp
                           )
                           Text(
                               text = "$userWeight",
                               color = Color.Black,
                               fontSize = 25.sp,
                               fontWeight = FontWeight.W500
                           )
                       }
                       VerticalDivider(
                           modifier = Modifier
                               .height(60.dp),
                           color = Color.Gray
                       )
                       Column(
                           modifier = Modifier
                               .weight(1f),
                           horizontalAlignment = Alignment.CenterHorizontally
                       ) {
                           Text(
                               text = stringResource(
                                   R.string.height
                               ),
                               color = Color(0xFF4F4F4F),
                               fontSize = 22.sp
                           )
                           Text(
                               text = String.format(Locale.getDefault(), "%.2f", userHeight),
                               color = Color.Black,
                               fontSize = 25.sp,
                               fontWeight = FontWeight.W500

                           )
                       }
                   }
               }
                Column (
                    modifier =  Modifier
                        .padding(top = 16.dp, bottom  = 16.dp)
                        .fillMaxWidth()
                        .height(250.dp)
                ){
//                    BmiLevel(
//                        bulletColor = colorResource(R.color.light_blue),
//                        leftText = stringResource(R.string.under_weight),
//                        rightText = "<${convertNumberToLocale(18.5)}",
//                        isFilled = if(bmi.bmiStatus == BmiStatus.UNDER_WEIGHT) true else false
//                    )
//                    BmiLevel(
//                        bulletColor = colorResource(R.color.light_green),
//                        leftText = stringResource(R.string.under_weight),
//                        rightText = "${convertNumberToLocale(18.6 -24.9)}",
//                        isFilled = if(bmi.bmiStatus == BmiStatus.NORMAL) true else false
//                    )
//                    BmiLevel(
//                        bulletColor = colorResource(R.color.yellow),
//                        leftText = stringResource(R.string.under_weight),
//                        rightText = "<${convertNumberToLocale(18.5)}",
//                        isFilled = if(bmi.bmiStatus == BmiStatus.OVER_WEIGHT) true else false
//                    )
//                    BmiLevel(
//                        bulletColor = colorResource(R.color.light_orange),
//                        leftText = stringResource(R.string.under_weight),
//                        rightText = "<${convertNumberToLocale(18.5)}",
//                        isFilled = if(bmi.bmiStatus == BmiStatus.OBESITY_1) true else false
//                    )
//                    BmiLevel(
//                        bulletColor = colorResource(R.color.dark_orange),
//                        leftText = stringResource(R.string.under_weight),
//                        rightText = "<${convertNumberToLocale(18.5)}",
//                        isFilled = if(bmi.bmiStatus == BmiStatus.OBESITY_2) true else false
//                    )
//                    BmiLevel(
//                        bulletColor = colorResource(R.color.red),
//                        leftText = stringResource(R.string.under_weight),
//                        rightText = "<${convertNumberToLocale(18.5)}",
//                        isFilled = if(bmi.bmiStatus == BmiStatus.OBESITY_3) true else false
//                    )
                    BmiLevel(
                        bulletColor = colorResource(R.color.light_blue),
                        leftText = stringResource(R.string.under_weight),
                        rightText = "< ${numberFormat(18.5)}",
                        isFilled = isFilled(bmi.bmiStatus, BmiStatus.UNDER_WEIGHT)
                    )
                    BmiLevel(
                        bulletColor = colorResource(R.color.light_green),
                        leftText = stringResource(R.string.normal_weight),
                        rightText = "${numberFormat(18.6)} - ${numberFormat(24.9)}",
                        isFilled = isFilled(bmi.bmiStatus, BmiStatus.NORMAL)
                    )
                    BmiLevel(
                        bulletColor = colorResource(R.color.yellow),
                        leftText = stringResource(R.string.over_weight),
                        rightText = "${numberFormat(25.0)} - ${numberFormat(29.9)}",
                        isFilled = isFilled(bmi.bmiStatus, BmiStatus.OVER_WEIGHT)
                    )
                    BmiLevel(
                        bulletColor = colorResource(R.color.light_orange),
                        leftText = stringResource(R.string.obesity_1),
                        rightText = "${numberFormat(30.0)} - ${numberFormat(34.9)}",
                        isFilled = isFilled(bmi.bmiStatus, BmiStatus.OBESITY_1)
                    )
                    BmiLevel(
                        bulletColor = colorResource(R.color.dark_orange),
                        leftText = stringResource(R.string.obesity_2),
                        rightText =  "${numberFormat(35.0)} - ${numberFormat(39.9)}",
                        isFilled = isFilled(bmi.bmiStatus, BmiStatus.OBESITY_2)
                    )
                    BmiLevel(
                        bulletColor =  colorResource(R.color.red),
                        leftText =  stringResource(R.string.obesity_3),
                        rightText = "> ${numberFormat(39.9)}",
                        isFilled = isFilled(bmi.bmiStatus, BmiStatus.OBESITY_3)
                    )

                }
                Button(
                    onClick = {
                        navegacao!!.navigate("dados")

                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF673AB7)
                    )
                ){
                    Text(
                        text = stringResource(
                            R.string.new_calc
                        ),
                        fontSize = 25.sp
                    )

                }


            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ResultScreenPreview(){
    ResultScreen(null)
}