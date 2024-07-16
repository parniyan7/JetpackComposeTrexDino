package com.parniyan.twodimensionaljumpinggame

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

/**
 ** Created by Parniyan on 7/15/2024.
 **
 */


@Composable
fun TRexGame(
    modifier: Modifier = Modifier,
    canvasWidth: Int = 800,
    canvasHeight: Int = 600,
    trexDrawable: Drawable,
    obstacleDrawable: Drawable
) {
    var trexY by remember { mutableStateOf(canvasHeight - 50f) }
    var obstacleX by remember { mutableStateOf(canvasWidth.toFloat()) }
    var gameState by remember { mutableStateOf<GameState>(GameState.RUNNING) }
    var score by remember { mutableStateOf(0) }
    val jumpForce = -200f
    val maxJumpHeight = 400f
    val obstacleSpeed = 5
    val gravityForce = 2f // Decreased gravity force
    val context = LocalContext.current
    val trexImage = trexDrawable.toBitmap().asImageBitmap()
    val obstacleImage = obstacleDrawable.toBitmap().asImageBitmap()

    val screenWidth = LocalConfiguration.current.screenWidthDp

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        // Handle space key press or tap on the canvas
                        if (gameState is GameState.RUNNING && trexY >= canvasHeight - 50f) {
                            trexY = maxOf(trexY + jumpForce, canvasHeight - maxJumpHeight)
                        }
                        //score
                        score += 1
                    }
                )
            }
    ) {
        val option = BitmapFactory.Options()
        option.inPreferredConfig = Bitmap.Config.ARGB_8888

        // Draw the T-Rex
        drawImage(
            image = trexImage,
            topLeft = Offset(50f, trexY)
        )

        // Draw the obstacle
        drawImage(
            image = obstacleImage,
            topLeft = Offset(obstacleX, canvasHeight - 20f)
        )

        drawLine(
            strokeWidth = 1.dp.toPx(),
            start = Offset(x = 0.dp.toPx(), y = canvasHeight.toFloat()),
            end = Offset(x = canvasWidth.toFloat() * 2, y = canvasHeight.toFloat()),
            color = Color.Gray,
        )

        // Update game state
        when (gameState) {
            is GameState.RUNNING -> {
                // Move the obstacle
                obstacleX -= obstacleSpeed

                // Apply gravity to the T-Rex
                trexY = minOf(trexY + gravityForce, canvasHeight - 50f)

                // Check for collision
                if (obstacleX <= 100f && trexY >= canvasHeight - 50f) {
                    gameState = GameState.GAME_OVER
                }

                // Reset the obstacle when it goes off-screen
                if (obstacleX < -50f) {
                    obstacleX = canvasWidth.toFloat()
                }

                //score text
                drawContext.canvas.nativeCanvas.drawText(
                    "Score: $score",
                    (canvasWidth / 2).toFloat(),
                    canvasHeight / 2f,
                    Paint().apply {
                        color = Color.Black.toArgb()
                        textSize = 40f
                    }
                )
            }

            is GameState.GAME_OVER -> {
                drawContext.canvas.nativeCanvas.drawText(
                    "Game Over",
                    (canvasWidth / 2).toFloat(),
                    canvasHeight / 2f,
                    Paint().apply {
                        color = Color.Black.toArgb()
                        textSize = 60f
                    }
                )
            }
        }
    }
}

sealed class GameState {
    data object RUNNING : GameState()
    data object GAME_OVER : GameState()
}

fun Drawable.toBitmap(): Bitmap {
    if (this is BitmapDrawable) {
        return this.bitmap
    } else {
        val bitmap = Bitmap.createBitmap(
            bounds.width(), bounds.height(), Bitmap.Config.ARGB_8888
        )
        val canvas = android.graphics.Canvas(bitmap)
        setBounds(0, 0, canvas.width, canvas.height)
        draw(canvas)
        return bitmap
    }
}




