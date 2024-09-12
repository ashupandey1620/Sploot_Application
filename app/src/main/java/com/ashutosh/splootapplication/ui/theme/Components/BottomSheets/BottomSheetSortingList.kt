package com.ashutosh.fsd.ui.theme.Component.BottomSheets

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ashutosh.fsd.ui.theme.Component.BottomSheets.Components.FolderClickItems
import com.ashutosh.fsd.ui.theme.Component.BottomSheets.Components.SortingListItems
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetSortingList(onDismiss: () -> Unit , modalBottomSheetState: SheetState) {

    ModalBottomSheet(
        shape = RoundedCornerShape(30.dp) ,
        onDismissRequest = {
            onDismiss()
                           },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = MaterialTheme.colorScheme.secondary,
        scrimColor = Color.Transparent
    ) {
        FolderClickItems()
    }
}