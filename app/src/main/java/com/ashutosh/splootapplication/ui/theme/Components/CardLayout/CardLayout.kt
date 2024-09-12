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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ashutosh.splootapplication.Presentation.NewsViewModel
import com.ashutosh.splootapplication.R


@Composable
fun CardFolderLayout(
    icon: Int ,
    name: String ,
    description: String ,
    modifiedDate: String ,
    navController: NavController ,
    onClick: () -> Unit
) {


    val newsVM : NewsViewModel = hiltViewModel()



    Column (modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .height(200.dp)
        .clip(RoundedCornerShape(15.dp))
        .background(Color.Gray.copy(0.3f))
        .clickable {

        }
       ,
        verticalArrangement = Arrangement.Top,
        ){




        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {

            Column ( modifier = Modifier
                .fillMaxWidth(0.75f)
                .padding(vertical = 5.dp)
                .padding(horizontal = 10.dp)){
                Text(
                    text = name ,
                    color = Color(0xFFF6F6F6) ,
                    fontSize = 16.sp ,
                    maxLines = 1 ,
                    softWrap = true ,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = description ,
                    color = Color(0xFFF6F6F6) ,
                    fontSize = 14.sp ,
                    maxLines = 1 ,
                    softWrap = true ,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Icon(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .padding(vertical = 5.dp)
                    .size(30.dp)
                    .clickable {
                        newsVM.isOpenFolderClick = !newsVM.isOpenFolderClick
                    },
                imageVector = Icons.Filled.MoreVert, contentDescription = "icon",
                tint = Color.White)

        }

        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = Modifier.padding(45.dp,20.dp)
        ) {
            Icon(
                painter = painterResource(id = icon) ,
                contentDescription = null ,
                modifier = Modifier
                    .fillMaxSize() ,
            )
            Column(
                modifier = Modifier
                    .padding(bottom = 18.dp)
                    .padding(start = 18.dp)
                    .size(30.dp) ,
                horizontalAlignment = Alignment.CenterHorizontally ,
                verticalArrangement = Arrangement.Center
            ) {

                Image(
                    painter = painterResource(R.drawable.file) ,
                    contentDescription = null ,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            onClick()
                        } ,
                    contentScale = ContentScale.Crop
                )

            }

        }
    }
}


@Preview()
@Composable
fun TeamItemPreview() {
//    FSDTheme {
//
//        CardFolderLayout(
//            R.drawable.folder ,
//            "Apple, Inc. (APPL)" ,
//            "177.15" ,
//            "0.88" ,
////            navController
//        ) {}
//    }

}
