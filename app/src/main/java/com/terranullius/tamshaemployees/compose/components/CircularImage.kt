package com.terranullius.tamshaemployees.compose.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.terranullius.tamshaemployees.R

val listProfileRes = listOf(
    R.drawable.ic_profile,
    R.drawable.ic_profile_2,
    R.drawable.ic_profile_3,
    R.drawable.ic_profile_4
)

@Composable
fun CircularUserImage(
    url: String?,
    modifier: Modifier = Modifier,
    size: Dp = 50.dp,
    @DrawableRes errorDrawableRes: Int = R.drawable.ic_profile
) {
    SubcomposeAsyncImage(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .border(1.dp, shape = CircleShape, color = MaterialTheme.colors.onSurface)
            .then(modifier),
        contentDescription = "pic",
        contentScale = ContentScale.Inside,
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        loading = {
            ImageProgressIndicator()
        },
        error = {
            Image(
                painter = painterResource(id = errorDrawableRes),
                contentDescription = ""
            )
        }
    )
}

@Composable
fun ImageProgressIndicator(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFF2D303E)
) {
    CircularProgressIndicator(
        modifier = modifier.then(
            Modifier.sizeIn(
                maxWidth = 60.dp,
                maxHeight = 60.dp
            )
        ), color = color
    )
}
