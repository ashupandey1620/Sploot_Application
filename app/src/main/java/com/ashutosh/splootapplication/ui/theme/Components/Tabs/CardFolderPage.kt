package com.ashutosh.growappassignment.ui.theme.Component.Tabs

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ashutosh.growappassignment.ui.theme.Component.CardLayout.CardFolderLayout
import com.ashutosh.splootapplication.R


data class SupportCardList(
    val icon: Int,
    val name: String,
    val description: String,
    val modifiedDate: String
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CardFolderPage(navController: NavController) {

    val gridState = rememberLazyGridState()

    val context = LocalContext.current

    val itemsList = listOf(
        SupportCardList(icon = R.drawable.folder, name = "Item 1", description = "A versatile folder", modifiedDate = "2023-08-01"),
        SupportCardList(icon = R.drawable.folder, name = "Item 2", description = "For office use", modifiedDate = "2023-09-12"),
        SupportCardList(icon = R.drawable.folder, name = "Item 3", description = "Sturdy and durable", modifiedDate = "2023-07-21"),
        SupportCardList(icon = R.drawable.folder, name = "Item 4", description = "Ideal for storing documents", modifiedDate = "2023-06-15"),
        SupportCardList(icon = R.drawable.folder, name = "Item 5", description = "High-quality material", modifiedDate = "2023-05-18"),
        SupportCardList(icon = R.drawable.folder, name = "Item 6", description = "Compact and easy to carry", modifiedDate = "2023-08-09"),
        SupportCardList(icon = R.drawable.folder, name = "Item 7", description = "Stylish and professional", modifiedDate = "2023-04-28"),
        SupportCardList(icon = R.drawable.folder, name = "Item 8", description = "Lightweight yet strong", modifiedDate = "2023-07-03"),
        SupportCardList(icon = R.drawable.folder, name = "Item 9", description = "Perfect for meetings", modifiedDate = "2023-03-30"),
        SupportCardList(icon = R.drawable.folder, name = "Item 10", description = "Classic design", modifiedDate = "2023-08-14"),
        SupportCardList(icon = R.drawable.folder, name = "Item 11", description = "Modern look", modifiedDate = "2023-05-23"),
        SupportCardList(icon = R.drawable.folder, name = "Item 12", description = "Durable and spacious", modifiedDate = "2023-06-11"),
        SupportCardList(icon = R.drawable.folder, name = "Item 13", description = "Eco-friendly materials", modifiedDate = "2023-09-01"),
        SupportCardList(icon = R.drawable.folder, name = "Item 14", description = "Sleek and minimalist", modifiedDate = "2023-04-16"),
        SupportCardList(icon = R.drawable.folder, name = "Item 15", description = "Great for presentations", modifiedDate = "2023-03-10"),
        SupportCardList(icon = R.drawable.folder, name = "Item 16", description = "Stylish and durable", modifiedDate = "2023-07-25"),
        SupportCardList(icon = R.drawable.folder, name = "Item 17", description = "Perfect for travel", modifiedDate = "2023-08-05"),
        SupportCardList(icon = R.drawable.folder, name = "Item 18", description = "Best for professionals", modifiedDate = "2023-06-19"),
        SupportCardList(icon = R.drawable.folder, name = "Item 19", description = "Water-resistant", modifiedDate = "2023-08-17"),
        SupportCardList(icon = R.drawable.folder, name = "Item 20", description = "Elegant and compact", modifiedDate = "2023-05-09")
    )


    val ItemsList = remember {
        mutableStateOf(itemsList)
    }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                ,
                verticalArrangement = Arrangement.Top ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                if (ItemsList.value != null && ItemsList.value!!.isNotEmpty()) {

                    LazyVerticalGrid(
                        state = gridState ,
                        columns = GridCells.Adaptive(180.dp) ,
                        modifier = Modifier
                            .fillMaxSize() ,
                        userScrollEnabled = true ,

                        contentPadding = PaddingValues(
                            start = 12.dp ,
                            top = 16.dp ,
                            end = 12.dp ,
                            bottom = 80.dp
                        ) ,
                        content = {

                            ItemsList?.let {
                                items(ItemsList.value!!.size) { it ->

                                    CardFolderLayout(
                                        ItemsList.value!!.get(it).icon,
                                        ItemsList.value!!.get(it).name ,
                                        ItemsList.value!!.get(it).description ,
                                        ItemsList.value!!.get(it).modifiedDate,
                                        navController
                                    ){
                                        Toast.makeText(context, "This is a Toast message!", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        }
                    )
                }

            }



}