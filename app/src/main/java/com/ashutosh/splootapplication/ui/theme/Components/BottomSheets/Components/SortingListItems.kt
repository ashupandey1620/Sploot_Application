package com.ashutosh.fsd.ui.theme.Component.BottomSheets.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SortingListItems(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth()
        .wrapContentHeight()
        .background(Color.White)){

        Column(modifier = Modifier
            .fillMaxWidth(0.75f)
            .padding(vertical = 5.dp)
            .padding(horizontal = 10.dp)) {
            Text(
                text = "First One" ,
                color = Color(0xFFF6F6F6) ,
                fontSize = 16.sp ,
                maxLines = 1 ,
                softWrap = true ,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Second One" ,
                color = Color(0xFFF6F6F6) ,
                fontSize = 14.sp ,
                maxLines = 1 ,
                softWrap = true ,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Third One",
                color = Color.Gray ,
                fontSize = 14.sp ,
                maxLines = 1 ,
                softWrap = true ,
                overflow = TextOverflow.Ellipsis
            )

            Column(modifier = Modifier.size(600.dp)
                .background(Color.Yellow)){

            }
        }






    }

}