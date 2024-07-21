package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


import android.content.res.Resources

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPaint()



        }
    }
}

@Composable
fun MyPaint() {



    val xLineCoordBegin = dpToPx(120f)
    val yLineCoordBegin = dpToPx(600f)

    val xLineCoordEnd = dpToPx(240f)
    val yLineCoordEnd = dpToPx(300f)

    val radiusCircle = dpToPx(48f)
    var alphaCircleFirst by remember { mutableStateOf(1f) }  // нужно для запоминания последнего состояния переменной - чтобы менять состояния
    var colorCircleSecond by remember { mutableStateOf(Color.Red) }

    val xCoordRectFirst = findCoordsRectDescribedAroundCircle(xLineCoordBegin, yLineCoordBegin,radiusCircle)[0]
    val yCoordRectFirst = findCoordsRectDescribedAroundCircle(xLineCoordBegin, yLineCoordBegin,radiusCircle)[1]

    val xCoordRectSecond = findCoordsRectDescribedAroundCircle(xLineCoordEnd, yLineCoordEnd,radiusCircle)[0]
    val yCoordRectSecond = findCoordsRectDescribedAroundCircle(xLineCoordEnd, yLineCoordEnd,radiusCircle)[1]



    val sizeRect = Size(2 * radiusCircle, 2 * radiusCircle)

    var xTouch = 0f
    var yTouch = 0f


    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.White)
            .pointerInput(Unit) {
                detectTapGestures (
                    onTap = {
                        coordinates ->
                            xTouch = coordinates.x
                            yTouch = coordinates.y

                        if ((xTouch >= xCoordRectFirst && xTouch <= xCoordRectFirst + 2 * radiusCircle)
                            && (yTouch >= yCoordRectFirst && yTouch <= yCoordRectFirst + 2 * radiusCircle)) {

                            alphaCircleFirst = 0.5f

                        }

                        if ((xTouch >= xCoordRectSecond && xTouch <= xCoordRectSecond + 2 * radiusCircle)
                            && (yTouch >= yCoordRectSecond && yTouch <= yCoordRectSecond + 2 * radiusCircle)) {

                            colorCircleSecond = Color.Yellow

                        }

                    })

            },
    ) {
        drawLine(color =Color.Black,
            start = Offset(x = xLineCoordBegin, y = yLineCoordBegin),
            end = Offset(x = xLineCoordEnd, y = yLineCoordEnd),
            strokeWidth = 10f,
        )

        drawCircle(color = Color.Blue,
            radius = radiusCircle,
            center = Offset(x = xLineCoordBegin, y = yLineCoordBegin),
            alpha = alphaCircleFirst,
        )
        drawRect(color = Color.Green,
            topLeft = Offset(x = xCoordRectFirst, y = yCoordRectFirst),
            size = sizeRect,
            alpha = 0.3f,
            style = Stroke(width = 10f)
        )

        drawCircle(color = colorCircleSecond,
            radius = radiusCircle,
            center = Offset(x = xLineCoordEnd, y = yLineCoordEnd),
        )
    }




}
@Composable
@Preview
fun MyPaintPreview() {
    MyPaint()
}

fun dpToPx(dp: Float) = dp * Resources.getSystem().displayMetrics.density


fun findCoordsRectDescribedAroundCircle(xCenterCircle: Float, yCenterCircle: Float, radiusCircle: Float): FloatArray {
    val xRect = xCenterCircle - radiusCircle
    val yRect = yCenterCircle - radiusCircle

    val coordinatesRect: FloatArray = floatArrayOf(xRect, yRect)

    return coordinatesRect
}
