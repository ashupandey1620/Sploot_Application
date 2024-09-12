package com.ashutosh.fsd.ui.theme.Theme

import android.content.Context


sealed class MainEvent {
	data class UpdateAppTheme(val theme: AppTheme , val context: Context) : MainEvent()
}

