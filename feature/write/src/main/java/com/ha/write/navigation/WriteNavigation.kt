package com.ha.write.navigation

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ha.util.Constants
import com.ha.util.Screen
import com.ha.util.model.Mood
import com.ha.write.WriteScreen
import com.ha.write.WriteViewModel

@OptIn(ExperimentalFoundationApi::class)
fun NavGraphBuilder.writeRoute(
    onBackPressed: () -> Unit,
    onDataLoaded: () -> Unit
) {
    composable(
        route = Screen.Write.route,
        arguments = listOf(navArgument(name = Constants.WRITE_SCREEN_ARGUMENT_KEY) {
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ) {
        val writeViewModel: WriteViewModel = hiltViewModel()
        val context = LocalContext.current
        val uiState = writeViewModel.uiState
        val galleryState = writeViewModel.galleryState
        val pagerState = rememberPagerState(pageCount = { Mood.values().size })
        val pageNumber by remember { derivedStateOf { pagerState.currentPage } }

        LaunchedEffect(key1 = Unit) {
            onDataLoaded()
        }

        WriteScreen(
            uiState = uiState,
            moodName = { Mood.values()[pageNumber].name },
            pagerState = pagerState,
            galleryState = galleryState,
            onTitleChanged = { writeViewModel.setTitle(title = it) },
            onDescriptionChanged = { writeViewModel.setDescription(description = it) },
            onDeleteConfirmed = {
                writeViewModel.deleteDiary(
                    onSuccess = {
                        Toast.makeText(
                            context,
                            "Deleted",
                            Toast.LENGTH_SHORT
                        ).show()
                        onBackPressed()
                    },
                    onError = { message ->
                        Toast.makeText(
                            context,
                            message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            },
            onDateTimeUpdated = { writeViewModel.updateDateTime(zonedDateTime = it) },
            onBackPressed = onBackPressed,
            onSaveClicked = {
                writeViewModel.upsertDiary(
                    diary = it.apply {
                        mood = Mood.values()[pageNumber].name
                    },
                    onSuccess = { onBackPressed() },
                    onError = { message ->
                        Toast.makeText(
                            context,
                            message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            },
            onImageSelect = {
                val type = context.contentResolver.getType(it)?.split("/")?.last() ?: "jpg"
                writeViewModel.addImage(
                    image = it,
                    imageType = type
                )
            },
            onImageDeleteClicked = {
                galleryState.removeImage(it)
            }
        )
    }
}
