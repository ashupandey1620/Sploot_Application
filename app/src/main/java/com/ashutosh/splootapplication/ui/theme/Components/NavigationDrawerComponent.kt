package com.ashutosh.growappassignment.ui.theme.Component

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.ashutosh.fsd.ui.theme.Theme.MainEvent
import com.ashutosh.fsd.ui.theme.Theme.MainState
import com.ashutosh.fsd.ui.theme.Theme.ThemeOptionComponent
import com.ashutosh.fsd.ui.theme.Theme.fontRobotoMono
import com.ashutosh.fsd.ui.theme.Theme.h2TextStyle
import com.ashutosh.fsd.ui.theme.Theme.h3TextStyle
import com.ashutosh.fsd.ui.theme.Theme.h4TextStyle
import com.ashutosh.splootapplication.R
import com.ashutosh.splootapplication.Util.Constants
import com.ashutosh.splootapplication.ui.theme.Blue200


@Composable
fun NavigationDrawerComponent(
	appState: MainState ,
	onMainEvent: (MainEvent) -> Unit ,
	onClickNews: () -> Unit
) {

	val context = LocalContext.current

	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.spacedBy(8.dp),
		modifier = Modifier
			.fillMaxHeight()
			.fillMaxWidth(0.7f)
	) {

		Spacer(modifier = Modifier.height(25.dp))
		Column(
			horizontalAlignment = Alignment.CenterHorizontally
		) {

			Card(modifier = Modifier.wrapContentSize(),
				shape = RoundedCornerShape(15.dp),
				border = BorderStroke(2.dp, Color.Gray)
			){
				Image(
					painter = painterResource(R.drawable.world_news) ,
					contentDescription = null ,
					modifier = Modifier
						.padding(9.dp)
						.width(80.dp)
						.wrapContentHeight() ,
				)
			}

			Text(
				text = "Samachar",
				style = h2TextStyle,
				modifier = Modifier.padding(vertical = 10.dp),
				color = MaterialTheme.colorScheme.onPrimary
			)
			Text(
				text = "Version ${Constants.APP_VERSION}",
				fontFamily = fontRobotoMono,
				fontSize = 15.sp,

				fontWeight = FontWeight.Bold,
				color = MaterialTheme.colorScheme.onPrimary
			)
		}

		Divider(thickness = 2.dp, color = MaterialTheme.colorScheme.secondary)

		Row(
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.spacedBy(16.dp)
		) {
			Text(
				text = "App Theme",
				style = h3TextStyle,
				color = MaterialTheme.colorScheme.onPrimary
			)

			ThemeOptionComponent(defaultTheme = appState.theme) {
				onMainEvent(MainEvent.UpdateAppTheme(it, context))
			}
		}



		Divider(thickness = 1.5.dp, color = Color.LightGray, modifier = Modifier.padding(bottom = 7.dp))

		Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

			NavDrawerItemUI(
				icon = R.drawable.ic_history,
				label = "This Week"
			) {}

			NavDrawerItemUI(
				icon =  R.drawable.mark,
				label = "Sports"
			) {}

			NavDrawerItemUI(
				icon =  R.drawable.mark,
				label = "India"
			) {}

			NavDrawerItemUI(
				icon =  R.drawable.bookmark,
				label = "Saved"
			) { onClickNews() }

		}

		Divider(thickness = 1.5.dp, color = Color.LightGray, modifier = Modifier.padding(bottom = 7.dp))


	}

}

@Composable
fun NavDrawerItemUI(icon: Int, label: String, onClick: () -> Unit) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.clickable { onClick() }
			.padding(15.dp , 5.dp),
		horizontalArrangement = Arrangement.spacedBy(10.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		Icon(
			modifier = Modifier.size(20.dp),
			painter = painterResource(id = icon),
			contentDescription = null,
			tint = MaterialTheme.colorScheme.onPrimary
		)
		Text(text = label, style = h4TextStyle, color = MaterialTheme.colorScheme.onPrimary)
	}
}

@Composable
fun NavDrawerFilesUI(icon: ImageVector, label: String, onClick: () -> Unit) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.clickable { onClick() }
			.padding(15.dp , 5.dp),
		horizontalArrangement = Arrangement.spacedBy(10.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		Icon(
			modifier = Modifier.size(25.dp),
			imageVector = icon,
			contentDescription = null,
			tint = MaterialTheme.colorScheme.onPrimary
		)
		Text(text = label, style = h4TextStyle, color = MaterialTheme.colorScheme.onPrimary)
	}
}

@Composable
fun NavDrawerSettingUI(icon: ImageVector, label: String, onClick: () -> Unit) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.clickable { onClick() }
			.padding(15.dp , 5.dp),
		horizontalArrangement = Arrangement.spacedBy(10.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		Icon(
			modifier = Modifier.size(25.dp),
			imageVector = icon,
			contentDescription = null,
			tint = MaterialTheme.colorScheme.onPrimary
		)
		Text(text = label, style = h4TextStyle, color = MaterialTheme.colorScheme.onPrimary)
	}
}


@Preview(widthDp = 350)
@Composable
fun NavigationDrawerComponentPreview() {
	NavigationDrawerComponent(MainState(), {},{})
}