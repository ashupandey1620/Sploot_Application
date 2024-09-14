package com.ashutosh.splootapplication.ui.theme.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ashutosh.fsd.ui.theme.Component.BottomSheets.BottomSheetSortingList
import com.ashutosh.fsd.ui.theme.Theme.MainEvent
import com.ashutosh.fsd.ui.theme.Theme.MainState
import com.ashutosh.fsd.ui.theme.Theme.h2TextStyle
import com.ashutosh.growappassignment.ui.theme.Component.NavigationDrawerComponent
import com.ashutosh.growappassignment.ui.theme.Component.Tabs.CardFolderPage
import com.ashutosh.splootapplication.Presentation.NewsViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(navController: NavController , appState: MainState ,
         onMainEvent: (MainEvent) -> Unit) {

    val newsVM : NewsViewModel = hiltViewModel()


    val modalBottomSheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = newsVM.isOpenFolderClick) {
        showBottomSheet = newsVM.isOpenFolderClick
        newsVM.getTopNews()
    }

    val context = LocalContext.current.applicationContext
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)



    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = MaterialTheme.colorScheme.primary) {
                NavigationDrawerComponent(
                    appState,
                    onMainEvent,
                    onClickNews = {
                        scope.launch {
                            drawerState.close()
                        }
                    }
                )
            }
        }) {
        Scaffold(modifier = Modifier.fillMaxSize() ,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    ),
                    title = {
                        Text(
                            text = "Top News Headlines",
                            style = h2TextStyle
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null
                            )
                        }
                    })
            } ,
            bottomBar = {


            },
            content = {

                Column {

                    Spacer(modifier = Modifier.size(70.dp))

                    CardFolderPage(navController)

                    if (showBottomSheet) {
                        LaunchedEffect(Unit) {
                            coroutineScope.launch {
                                modalBottomSheetState.show()
                            }
                        }

                        BottomSheetSortingList(
                            onDismiss = {
                                coroutineScope.launch {
                                    newsVM.isOpenFolderClick = false
                                    modalBottomSheetState.hide()
                                    showBottomSheet = false
                                }
                            },
                            modalBottomSheetState
                        )
                    }
                }
            }
        )
    }

}