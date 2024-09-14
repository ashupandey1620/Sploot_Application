package com.ashutosh.growappassignment.ui.theme.Component.CardLayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ashutosh.splootapplication.Presentation.NewsViewModel
import com.ashutosh.splootapplication.R
import com.ashutosh.splootapplication.ui.theme.SplootApplicationTheme


@Composable
fun CardFolderLayout(
    author: String,
    content: String,
    description: String,
    publishedAt: String,
    source: String ,
    title: String ,
    url: String ,
    urlToImage: String ,
    navController: NavController ,
    onClick: () -> Unit
) {


    val newsVM : NewsViewModel = hiltViewModel()


    val context = LocalContext.current

    Column (modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .wrapContentHeight()
        .clip(RoundedCornerShape(15.dp))
        .background(Color.Gray.copy(0.3f))
        .clickable {
            newsVM.selectID = url
            newsVM.isOpenFolderClick = !newsVM.isOpenFolderClick
        }
       ,
        verticalArrangement = Arrangement.Top,
        ){

        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(urlToImage)
                .crossfade(true)
                .build(),
            contentDescription = "Loaded image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
            ,
        )

            Column ( modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .padding(horizontal = 10.dp)){
                Text(
                    text = title ,
                    color = Color(0xFFF6F6F6) ,
                    fontSize = 16.sp ,
                    maxLines = 2 ,
                    lineHeight = 18.sp,
                    softWrap = true ,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = description ,
                    color = Color.LightGray ,
                    fontSize = 12.sp ,
                    maxLines = 3 ,
                    softWrap = true ,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 14.sp
                )
            }
    }
}


@Preview()
@Composable
fun TeamItemPreview() {
//    SplootApplicationTheme {
//        CardFolderLayout(
//            "Author of the news" ,
//            "Content of the news should be wuite long so njndjn jfnesdjs sjnflsf  jsenflsf selknfsnf" ,
//            "description lorem",
//            "today" ,
//            "hh",
//            "hhdh",
//            "jdjjd",
//            "https://unsplash.com/photos/a-person-sitting-on-a-rock-in-the-middle-of-a-field-nRGg4jofz8U"
//        ) {}
//    }

}
