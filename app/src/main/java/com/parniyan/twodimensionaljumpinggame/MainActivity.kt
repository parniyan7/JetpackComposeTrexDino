package com.parniyan.twodimensionaljumpinggame

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.parniyan.twodimensionaljumpinggame.ui.theme.TwoDimensionalJumpingGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TwoDimensionalJumpingGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val context = LocalContext.current
                    val trexDrawable: Drawable = ContextCompat.getDrawable(context, R.drawable.dino)!!
                    val obstacleDrawable: Drawable = ContextCompat.getDrawable(context, R.drawable.tree)!!

                    TRexGame(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(color = Color.White),
                        trexDrawable = trexDrawable,
                        obstacleDrawable = obstacleDrawable
                    )
                }
            }
        }
    }
}
