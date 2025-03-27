package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataScreen (navegacao: NavHostController?){

    var ageState = remember {
        mutableStateOf("")
    }
    var weightState = remember {
        mutableStateOf("")
    }
    var heightState = remember {
        mutableStateOf("")
    }

    val contexto =  LocalContext.current
    val userFile = contexto
        .getSharedPreferences("userFile", Context.MODE_PRIVATE)

    val userName = userFile.getString("user_name", "User name not found!")


    val editor = userFile.edit()

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
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top= 70.dp,start = 20.dp, end = 20.dp),
        ){
            Text(
                text = stringResource(
                    R.string.hello
                ) + ", $userName!",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 160.dp),
            shape = RoundedCornerShape(
                topStart = 48.dp,
                topEnd = 48.dp
            ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 30.dp, start = 30.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ){
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()

                        ){
                        Column (
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally

                        ){
                            Image(
                                painter = painterResource(
                                    R.drawable.userm
                                ),
                                contentDescription = stringResource(
                                    R.string.logo
                                ),
                                modifier = Modifier

                                    .height(160.dp)
                                    .width(160.dp)
                            )
                            Button(
                                onClick = {},
                                shape = RoundedCornerShape(100.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF9C27B0)
                                )

                            ){

                                Text(
                                    text = stringResource(
                                        R.string.male

                                    ),
                                    fontSize = 16.sp
                                )

                            }
                        }
                        Column (
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Image(
                                painter = painterResource(
                                    R.drawable.userf
                                ),
                                contentDescription = stringResource(
                                    R.string.logo
                                ),
                                modifier = Modifier

                                    .height(160.dp)
                                    .width(160.dp)
                            )
                            Button(
                                onClick = {},
                                shape = RoundedCornerShape(100.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFD53368)
                                )
                            ){

                                Text(
                                    text = stringResource(
                                         R.string.female
                                    ),
                                    fontSize = 16.sp
                                )

                            }
                        }
                    }
                    Column {
                        OutlinedTextField(
                            value = ageState.value,
                            onValueChange = {
                                ageState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 15.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Numbers,
                                    contentDescription = "",
                                    tint = Color(0xFF673AB7)
                                )
                            },
                            shape = RoundedCornerShape(10.dp),
                            label = { Text(text = stringResource(R.string.age) ) }

                        )
                        OutlinedTextField(
                            value = weightState.value,
                            onValueChange = {
                                weightState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 15.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Balance,
                                    contentDescription = "",
                                    tint = Color(0xFF673AB7)
                                )
                            },
                            shape = RoundedCornerShape(10.dp),
                            label = { Text(text = stringResource(R.string.weight) ) }

                        )
                        OutlinedTextField(
                            value = heightState.value,
                            onValueChange = {
                                heightState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 15.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Decimal,
                                imeAction = ImeAction.Done
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Height,
                                    contentDescription = "",
                                    tint = Color(0xFF673AB7)
                                )
                            },
                            shape = RoundedCornerShape(10.dp),
                            label = { Text(text = stringResource(R.string.height) ) }


                        )
                    }
                    Button(
                        onClick = {
                            editor.putInt("age", ageState.value.toInt())
                            editor.putInt("weight", weightState.value.toInt())
                            editor.putFloat("height", heightState.value.toFloat())
                            editor.apply()

                            navegacao!!.navigate("resultado")
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
                                R.string.calculate
                            ),
                            fontSize = (25.sp)

                        )

                    }
                }



            }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun UserDataScreenPreview(){
  UserDataScreen(navegacao = null)
}