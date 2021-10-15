/*******************************************************************************
 *  Copyright (c) 2021 OrlanDroyd
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 *  distribute, sublicense, create a derivative work, and/or sell copies of the
 *  Software in any work that is designed, intended, or marketed for pedagogical or
 *  instructional purposes related to programming, coding, application development,
 *  or information technology.  Permission for such use, copying, modification,
 *  merger, publication, distribution, sublicensing, creation of derivative works,
 *  or sale is expressly withheld.
 *
 *  This project and source code may use libraries or frameworks that are
 *  released under various Open-Source licenses. Use of those libraries and
 *  frameworks are governed by their own individual licenses.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 *
 ******************************************************************************/

package com.gmail.orlandroyd.composeexample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gmail.orlandroyd.composeexample.R
import com.gmail.orlandroyd.composeexample.router.BackButtonHandler
import com.gmail.orlandroyd.composeexample.router.JetFundamentalsRouter
import com.gmail.orlandroyd.composeexample.router.Screen

val THREE_ELEMENT_LIST = listOf(R.string.first, R.string.second, R.string.third)
val THREE_ELEMENT_COLOR = listOf(R.color.colorPrimary, R.color.colorSecondary, R.color.black)

@Composable
fun RowScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ///
        Text(text = "Evenly", modifier = Modifier.padding(4.dp))
        LineSpace()
        MyRowEvenly()
        LineSpace()
        ///
        Text(text = "Around", modifier = Modifier.padding(4.dp))
        LineSpace()
        MyRowAround()
        LineSpace()
        ///
        Text(text = "Between", modifier = Modifier.padding(4.dp))
        LineSpace()
        MyRowBetween()
        LineSpace()
        ///
        Text(text = "Center", modifier = Modifier.padding(4.dp))
        LineSpace()
        MyRowCenter()
        LineSpace()
        ///
        Text(text = "Start", modifier = Modifier.padding(4.dp))
        LineSpace()
        MyRowStart()
        LineSpace()
        ///
        Text(text = "End", modifier = Modifier.padding(4.dp))
        LineSpace()
        MyRowEnd()
        LineSpace()
        ///
        Text(text = "Using Weight", modifier = Modifier.padding(4.dp))
        LineSpace()
        MyRowWeight()
        LineSpace()
    }

    BackButtonHandler {
        JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun LineSpace() {
    Spacer(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(2.dp)
            .background(colorResource(R.color.black))
    )
}

@Preview
@Composable
fun MyRowEvenly() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        THREE_ELEMENT_LIST.forEachIndexed { index, textResId ->
            Text(
                text = stringResource(id = textResId),
                fontSize = 18.sp,
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .background(
                        colorResource(id = THREE_ELEMENT_COLOR[index])
                    )
            )
        }
    }
}

@Preview
@Composable
fun MyRowAround() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        THREE_ELEMENT_LIST.forEachIndexed { index, textResId ->
            Text(
                text = stringResource(id = textResId),
                fontSize = 18.sp,
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .background(
                        colorResource(id = THREE_ELEMENT_COLOR[index])
                    )
            )
        }
    }
}

@Preview
@Composable
fun MyRowBetween() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        THREE_ELEMENT_LIST.forEachIndexed { index, textResId ->
            Text(
                text = stringResource(id = textResId),
                fontSize = 18.sp,
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .background(
                        colorResource(id = THREE_ELEMENT_COLOR[index])
                    )
            )
        }
    }
}

@Preview
@Composable
fun MyRowCenter() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        THREE_ELEMENT_LIST.forEachIndexed { index, textResId ->
            Text(
                text = stringResource(id = textResId),
                fontSize = 18.sp,
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .background(
                        colorResource(id = THREE_ELEMENT_COLOR[index])
                    )
            )
        }
    }
}

@Preview
@Composable
fun MyRowStart() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        THREE_ELEMENT_LIST.forEachIndexed { index, textResId ->
            Text(
                text = stringResource(id = textResId),
                fontSize = 18.sp,
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .background(
                        colorResource(id = THREE_ELEMENT_COLOR[index])
                    )
            )
        }
    }
}

@Preview
@Composable
fun MyRowEnd() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
        modifier = Modifier.fillMaxWidth()
    ) {
        THREE_ELEMENT_LIST.forEachIndexed { index, textResId ->
            Text(
                text = stringResource(id = textResId),
                fontSize = 18.sp,
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .background(
                        colorResource(id = THREE_ELEMENT_COLOR[index])
                    )
            )
        }
    }
}

@Preview
@Composable
fun MyRowWeight() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = THREE_ELEMENT_LIST[0]),
                fontSize = 18.sp,
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .weight(1f)
                    .background(
                        colorResource(id = THREE_ELEMENT_COLOR[0])
                    )
            )
            Text(
                text = stringResource(id = THREE_ELEMENT_LIST[1]),
                fontSize = 18.sp,
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .weight(2f)
                    .background(
                        colorResource(id = THREE_ELEMENT_COLOR[1])
                    )
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = THREE_ELEMENT_LIST[2]),
                fontSize = 18.sp,
                color = colorResource(id = R.color.white),
                modifier = Modifier
                    .weight(1 / 3f)
                    .background(
                        colorResource(id = THREE_ELEMENT_COLOR[2])
                    )
            )
        }
    }
}