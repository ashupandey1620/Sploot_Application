package com.ashutosh.growappassignment.ui.theme.Component.Tabs

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

                var searchText by remember { mutableStateOf("") }
                val containerColor = Color(0xFF222222)
                val keyboardController = LocalSoftwareKeyboardController.current



                OutlinedTextField(

                    value = searchText,
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Search, contentDescription = "icon",
                            tint = Color(0xFFA7A7A7)
                        )
                    },
                    onValueChange = { searchText = it },
                    shape = RoundedCornerShape(15.dp) ,
                    prefix = {
                        Text(
                            text = "" ,
                            color = Color(0xFFF6F6F6) ,
                            fontSize = 14.sp
                        )
                    },


                    placeholder = { Text(text = "Search News...", color = Color(0xFFA7A7A7)
                         ,fontSize = 14.sp) },

                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Text
                    ) ,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White ,
                        unfocusedTextColor = Color.White,
                        focusedContainerColor = containerColor ,
                        unfocusedContainerColor = containerColor ,
                        disabledContainerColor = containerColor ,
                        focusedBorderColor = Color(0xFF555555) ,
                        unfocusedBorderColor = Color(0xFF555555) ,
                    ) ,
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .padding(top = 14.dp)
                        .padding(horizontal = 20.dp),

                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                            //



                        }
                    ) ,

                    )

                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp))

                val filteredItems = ItemsList.value?.filter {
                    it.title.contains(searchText, ignoreCase = true)
                }



                if (filteredItems!= null && filteredItems!!.isNotEmpty()) {

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
                                items(filteredItems!!.size) { it ->
                                    CardFolderLayout(
                                        filteredItems!!.get(it).author,
                                        filteredItems!!.get(it).content ,
                                        filteredItems!!.get(it).description ,
                                        filteredItems!!.get(it).publishedAt,
                                        filteredItems!!.get(it).source,
                                        filteredItems!!.get(it).title ,
                                        filteredItems!!.get(it).url,
                                        filteredItems!!.get(it).urlToImage,
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