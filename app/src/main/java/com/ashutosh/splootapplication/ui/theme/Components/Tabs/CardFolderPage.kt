package com.ashutosh.growappassignment.ui.theme.Component.Tabs

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ashutosh.growappassignment.ui.theme.Component.CardLayout.CardFolderLayout
import com.ashutosh.splootapplication.Presentation.NewsViewModel
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

    val gridState = rememberLazyListState()

    val context = LocalContext.current

    val newsVM: NewsViewModel = hiltViewModel()
    val ItemsList = newsVM.getNews.observeAsState()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                ,
                verticalArrangement = Arrangement.Top ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                if (ItemsList.value != null && ItemsList.value!!.isNotEmpty()) {

                    LazyColumn(
                        state = gridState ,
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
                                        ItemsList.value!!.get(it).author,
                                        ItemsList.value!!.get(it).content ,
                                        ItemsList.value!!.get(it).description ,
                                        ItemsList.value!!.get(it).publishedAt,
                                        ItemsList.value!!.get(it).source,
                                        ItemsList.value!!.get(it).title ,
                                        ItemsList.value!!.get(it).url,
                                        ItemsList.value!!.get(it).urlToImage,
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