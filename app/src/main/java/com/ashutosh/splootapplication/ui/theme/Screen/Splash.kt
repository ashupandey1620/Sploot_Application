package com.ashutosh.splootapplication.ui.theme.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ashutosh.splootapplication.Navigation.Routes
import com.ashutosh.splootapplication.R
import com.ashutosh.splootapplication.ui.theme.SplootApplicationTheme
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Splash(navController: NavController) {





    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.popBackStack()
        navController.navigate(Routes.Main.name)
    }



    Scaffold(modifier = Modifier
        .fillMaxSize(),
        content = {



            Column(
                modifier = Modifier
                    .fillMaxSize() ,
                verticalArrangement = Arrangement.Center ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {



                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center)
                {
                    Image(
                        modifier = Modifier.width(220.dp)
                            .wrapContentHeight(), painter = painterResource(id = R.drawable.tablet) , contentDescription = "",
                        colorFilter = ColorFilter.tint(Color.White))

                    Text(text = " Online Samachaar",
                        modifier = Modifier
                            .width(150.dp)
                            .wrapContentHeight(),
                        color = Color.White,
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        letterSpacing = 2.sp
                    )

                }





            }
        }
    )
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview()
@Composable
fun SplashPreview() {
    SplootApplicationTheme{
        Scaffold(modifier = Modifier
            .fillMaxSize(),
            content = {

                Column(
                    modifier = Modifier
                        .fillMaxSize() ,
                    verticalArrangement = Arrangement.Center ,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {



                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center)
                    {
                        Image(
                            modifier = Modifier.width(220.dp)
                                .wrapContentHeight(), painter = painterResource(id = R.drawable.tablet) , contentDescription = "")

                        Text(text = " Online Samachaar",
                            modifier = Modifier
                                .width(150.dp)
                                .wrapContentHeight(),
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                            letterSpacing = 2.sp
                        )

                    }





                }
            }
        )
    }
}