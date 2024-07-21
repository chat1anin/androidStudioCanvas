package com.example.myapplication

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
//import java.lang.reflect.Modifier
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(name: String) {
    Column(modifier = Modifier.fillMaxSize())
      {
        Text("$name",
            fontSize = 64.sp,
            color = Color.Red,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.background(color = Color.White).width(200.dp).height(150.dp).background(color = Color.Green, shape = CircleShape)
        )

        Spacer(modifier = Modifier.width(20.dp))

        Text("$name",
            fontSize = 64.sp,
            color = Color.Red,
            textAlign = TextAlign.Right,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.background(color = Color.Black).width(200.dp).height(150.dp)
        )


    }

}

//@Composable
//fun MyPaint() {
//    Canvas(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//            .background(color = Color.White),
//        onDraw = {
//            drawLine(color =Color.Black,
//                start = Offset(x = size.width  / 4, y = size.height * 2 / 3),
//                end = Offset(x = size.width * 2 / 4, y = size.height / 3),
//                strokeWidth = 10f,
//            )
//        }
//    )
//}
//@Composable
//@Preview
//fun MyPaintPreview() {
//    MyPaint()
//}