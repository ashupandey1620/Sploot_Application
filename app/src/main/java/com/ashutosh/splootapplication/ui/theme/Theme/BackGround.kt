package com.ashutosh.fsd.ui.theme.Theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun background(): Brush {

    val colorsDark = listOf(
        Color(0xFF1E1E1E),
        Color(0xFF1E1E1E),
        Color(0xFF1E1E1E),
        Color(0xFF1E1E1E),
        Color(0xFF1E1E1E)
    )
    

    return Brush.linearGradient(
        colors = colorsDark, start = Offset.Zero, end = Offset(
            Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY
        )
    )
}



@Composable
fun goldenCard(): Brush {

    val colorsGold = listOf(
        Color(0xFFce9d1e),
        Color(0xFFce9d1e),
        Color(0xFFcb9b1d),
        Color(0xFFcb9b1d),
        Color(0xFFc1931c),
        Color(0xFFc1931c),
        Color(0xFFb58a1a),
        Color(0xFFb58a1a),
        Color(0xFFaf851a),
        Color(0xFFaf851a),
        Color(0xFFa07918),


        Color(0xFF816316),
        Color(0xFF816316),
        Color(0xFF735817),
        Color(0xFF735817),
        Color(0xFF664f17),
        Color(0xFF664f17),
    )

    return Brush.linearGradient(
        colors = colorsGold, start = Offset.Zero, end = Offset(
            Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY
        )
    )
}


@Composable
fun goldenBackground(): Brush {

    val colorsDark = listOf(
        Color(0xFFCC9913),
        Color(0xFFCC9913),
        Color(0xFFCC9913),
        Color(0xFFCC9913),
        Color(0xFFCC9913)
    )

    val colorsBright = listOf(
        Color(0xFFf8efe0),
        Color(0xFFfffaf1),
        Color(0xFFfffaf1),
        Color(0xFFe6d8bf),
        Color(0xFFe6d8bf),
    )

    return Brush.linearGradient(
        colors = colorsDark, start = Offset.Zero, end = Offset(
            Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY
        )
    )
}


