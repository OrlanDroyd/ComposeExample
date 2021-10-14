/*
 * Copyright (c) 2021 OrlanDroyd LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.gmail.orlandroyd.composeexample.screens

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gmail.orlandroyd.composeexample.R
import com.gmail.orlandroyd.composeexample.router.BackButtonHandler
import com.gmail.orlandroyd.composeexample.router.JetFundamentalsRouter
import com.gmail.orlandroyd.composeexample.router.Screen
import com.gmail.orlandroyd.composeexample.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun ExploreButtonsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        MyButton()
        Spacer(modifier = Modifier.height(16.dp))
        MyRadioGroup()
        Spacer(modifier = Modifier.height(16.dp))
        MyFloatingActionButton()
        Spacer(modifier = Modifier.height(16.dp))
        MyGradientButton()
        Spacer(modifier = Modifier.height(16.dp))
        MyGoogleLoginButton(onClicked = {
            Log.d("googleButton", "Clicked")
        })

        BackButtonHandler {
            JetFundamentalsRouter.navigateTo(Screen.Navigation)
        }
    }
}

@Preview
@Composable
fun MyButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(R.color.colorPrimary)
        ),
        border = BorderStroke(
            1.dp,
            color = colorResource(R.color.colorPrimaryVariant)
        )
    ) {
        Text(
            text = stringResource(R.string.button_text),
            color = Color.White
        )
    }
}

@Preview
@Composable
fun MyRadioGroup() {

    val radioButtons = listOf(0, 1, 2)

    val selectedButton = remember {
        mutableStateOf(radioButtons.first())
    }

    Column {
        radioButtons.forEach { index ->
            val isSelected = index == selectedButton.value
            val colors = RadioButtonDefaults.colors(
                selectedColor = colorResource(R.color.colorPrimary),
                unselectedColor = colorResource(R.color.colorPrimaryVariant),
                disabledColor = Color.LightGray
            )
            Row(
                modifier = Modifier.clickable {
                    selectedButton.value = index
                },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                RadioButton(
                    colors = colors,
                    selected = isSelected,
                    onClick = { }
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Radio Button ${index + 1}")
            }
        }
    }

}

@Preview
@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = {},
        backgroundColor = colorResource(R.color.colorPrimary),
        contentColor = Color.White,
        content = {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Test FAB"
            )
        }
    )
}

@Preview
@Composable
fun MyGradientButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        contentPadding = PaddingValues()
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF682873),
                            Color(0xFF632893)
                        )
                    )
                )
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.button_text),
                color = Color.White
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun MyGoogleLoginButton(
    text: String = "Sign Up with Google",
    loadingText: String = "Creating Account",
    icon: Painter = painterResource(id = R.drawable.google),
    shape: Shape = Shapes.medium,
    borderColor: Color = Color.LightGray,
    backgroundColor: Color = MaterialTheme.colors.surface,
    progressIndicatorColor: Color = MaterialTheme.colors.primary,
    onClicked: () -> Unit
) {

    var clicked by remember { mutableStateOf(false) }

    Surface(
        onClick = { clicked = !clicked },
        shape = shape,
        border = BorderStroke(
            width = 1.dp,
            color = borderColor
        ),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier.padding(
                start = 12.dp,
                end = 16.dp,
                top = 12.dp,
                bottom = 12.dp
            )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Icon(
                modifier = Modifier.width(20.dp).height(20.dp),
                painter = icon,
                contentDescription = "Google button",
                tint = Color.Unspecified
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = if (clicked) loadingText else text)

            if (clicked) {

                Spacer(modifier = Modifier.width(16.dp))

                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )
                onClicked()
            }
        }
    }
}