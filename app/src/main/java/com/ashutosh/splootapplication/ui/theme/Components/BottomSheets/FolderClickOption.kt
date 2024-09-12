package com.ashutosh.fsd.ui.theme.Component.BottomSheets

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ashutosh.fsd.ui.theme.Component.BottomSheets.Components.FolderClickItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FolderClickOption(onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        shape = RoundedCornerShape(30.dp) ,
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = Color.Yellow,
        scrimColor = Color.Blue
    ) {
        FolderClickItems()
    }
}

