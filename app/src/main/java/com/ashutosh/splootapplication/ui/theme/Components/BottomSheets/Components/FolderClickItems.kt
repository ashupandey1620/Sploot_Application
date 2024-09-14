package com.ashutosh.fsd.ui.theme.Component.BottomSheets.Components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import com.ashutosh.splootapplication.Data.News.Dao.News
import com.ashutosh.splootapplication.Presentation.NewsViewModel

import com.ashutosh.splootapplication.R

@Composable
fun FolderClickItems() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(10.dp)
        ){

        val newsVM : NewsViewModel = hiltViewModel()
        var url = newsVM.selectID

        val newsItem by newsVM.newsItem.collectAsState()
        newsVM.getNewsByUrl(url)
        
        
        if (newsItem != null) {
            NewsMaterial(newsItem!!)
        } else {
            Text(text = "Loading...")
        }
        
        Spacer(modifier = Modifier.size(200.dp))








    }
}

@Composable
fun NewsMaterial(newsItem: News) {
    Column (){

        val context = LocalContext.current
        Text(
            text = newsItem.title ,
            color = Color(0xFFF6F6F6) ,
            fontSize = 15.sp ,
            maxLines = 2 ,
            lineHeight = 17.sp,
            softWrap = true ,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(5.dp)
        )

        Text(
            text = newsItem.description ,
            color = Color.LightGray ,
            fontSize = 12.sp ,
            lineHeight = 14.sp,
            modifier = Modifier.padding(5.dp)
        )


        Text(
            text = "Source : ${newsItem.source}" ,
            color = Color.White ,
            fontSize = 14.sp ,
            lineHeight = 16.sp,
            modifier = Modifier.padding(5.dp)
        )


        Text(
            text = "Content : ${newsItem.content}" ,
            color = Color.White ,
            fontSize = 14.sp ,
            lineHeight = 16.sp,
            modifier = Modifier.padding(5.dp)
        )

        Text(
            text = "Published at : ${newsItem.publishedAt}" ,
            color = Color.White ,
            fontSize = 14.sp ,
            lineHeight = 16.sp,
            modifier = Modifier.padding(5.dp)
        )


        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(newsItem.url))
                    context.startActivity(intent)
                },
            text = "Read Full News" ,
            color = Color.Blue ,
            textAlign = TextAlign.Center,
            fontSize = 14.sp ,
            lineHeight = 16.sp,
            fontWeight = FontWeight.ExtraBold,

        )



    }
}

