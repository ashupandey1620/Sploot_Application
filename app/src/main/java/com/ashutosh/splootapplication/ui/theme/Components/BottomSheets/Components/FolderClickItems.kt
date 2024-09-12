package com.ashutosh.fsd.ui.theme.Component.BottomSheets.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashutosh.fsd.R

@Composable
fun FolderClickItems() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        ){

        BottomSheetOptions(R.drawable.folder2,"FSD") {}
        Divider()
        BottomSheetOptions(R.drawable.add_group,"Manage Access") {}
        BottomSheetOptions(R.drawable.star,"Add to Starred") {}
        BottomSheetOptions(R.drawable.link,"Copy Link") {}
        Divider(thickness = 0.5.dp)
        BottomSheetOptions(R.drawable.editing,"Rename") {}
        Divider(thickness = 0.5.dp)
        BottomSheetOptions(R.drawable.palette,"Change Color") {}
        BottomSheetOptions(R.drawable.send,"Move") {}
        BottomSheetOptions(R.drawable.info,"Details and Activity") {}
        BottomSheetOptions(R.drawable.recent,"Add to Home Screen") {}
        BottomSheetOptions(R.drawable.delete,"Remove") {}
        Spacer(modifier = Modifier.padding(20.dp))

    }
}

@Composable
fun BottomSheetOptions(icon: Int , str: String , onClick: () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick() }
        .padding(10.dp)
        , verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start){

        Icon(
            modifier = Modifier
                .padding(horizontal = 17.dp)
                .padding(vertical = 5.dp)
                .size(25.dp)
                .clickable {

                },
            painter = painterResource(id = icon), contentDescription = "icon",
            tint = Color.Gray)

        Text(
            text = str ,
            color = Color.White ,
            fontSize = 18.sp ,
            maxLines = 1 ,
            softWrap = true ,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Light
        )


    }
}
