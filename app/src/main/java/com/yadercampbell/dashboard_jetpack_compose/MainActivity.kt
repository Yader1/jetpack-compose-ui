package com.yadercampbell.dashboard_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.yadercampbell.dashboard_jetpack_compose.ui.theme.DashboardJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DashboardJetpackComposeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Dashboard()
                }
            }
        }
    }
}

@Composable
fun Dashboard() {
    Column (
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.parseColor("#eeeefb")))
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ConstraintLayout {
            val (topImg, profile) = createRefs()
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(245.dp)
                    .constrainAs(topImg) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .background(
                        color = Color(android.graphics.Color.parseColor("#5e3bee")),
                        shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)
                    )
            )
            Row (
                modifier = Modifier
                    .padding(top = 48.dp, start = 24.dp, end = 24.dp)
                    .fillMaxWidth()
            ){
                Column (
                    modifier = Modifier
                        .height(100.dp)
                        .padding(start = 14.dp)
                        .weight(0.7f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ){
                    Text(text = "Hello", color = Color.White, fontSize = 18.sp)
                    Text(
                        text = "YADER CAMPBELL",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 14.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clickable { }
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(20.dp))
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .constrainAs(profile) {
                        top.linkTo(topImg.bottom)
                        bottom.linkTo(topImg.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ){
                Column(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, end = 12.dp)
                        .height(90.dp)
                        .width(90.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#b6c2fe")),
                            shape = RoundedCornerShape(20.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.video_call),
                        contentDescription = null,
                        Modifier.padding(top = 8.dp, bottom = 4.dp)
                    )
                    Text(
                        text = "Video Call",
                        color = Color(android.graphics.Color.parseColor("#5e3bee")),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, end = 8.dp, start = 8.dp)
                        .height(90.dp)
                        .width(90.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#b6c2fe")),
                            shape = RoundedCornerShape(20.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.notification),
                        contentDescription = null,
                        Modifier.padding(top = 8.dp, bottom = 4.dp)
                    )
                    Text(
                        text = "Notification",
                        color = Color(android.graphics.Color.parseColor("#5e3bee")),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp)
                        .height(90.dp)
                        .width(90.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#b6c2fe")),
                            shape = RoundedCornerShape(20.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.voice_call),
                        contentDescription = null,
                        Modifier.padding(top = 8.dp, bottom = 4.dp)
                    )
                    Text(
                        text = "Voice Call",
                        color = Color(android.graphics.Color.parseColor("#5e3bee")),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }

        var text by rememberSaveable { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "Searching for...")},
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(43.dp)
                        .padding(end = 6.dp)
                )
            },
            shape = RoundedCornerShape(50.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.White,
                focusedLabelColor = Color.Transparent,
                disabledContainerColor = Color.White,
                disabledTextColor = Color(android.graphics.Color.parseColor("#5e5e5e")),
                unfocusedLabelColor = Color(android.graphics.Color.parseColor("#5e5e5e"))
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp, end = 24.dp, start = 24.dp)
                .shadow(3.dp, shape = RoundedCornerShape(50.dp))
                .background(Color.White, CircleShape)
        )

        ConstraintLayout (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 21.dp, end = 24.dp, start = 24.dp)
                .shadow(3.dp, shape = RoundedCornerShape(25.dp))
                .height(145.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#7787f9")),
                            Color(android.graphics.Color.parseColor("#b6c2fe"))
                        )
                    ),
                    shape = RoundedCornerShape(25.dp)
                )
        ){
            val (img, text1, text2) = createRefs()

            Image(
                modifier = Modifier.constrainAs(img){
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null
            )
            Text(
                text = "To Get Unlimited",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .constrainAs(text1) {
                        top.linkTo(parent.top)
                        end.linkTo(img.start)
                        start.linkTo(parent.start)
                    }
            )
            Text(
                text = "Upgrade Your Account",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .constrainAs(text2) {
                        top.linkTo(text1.bottom)
                        end.linkTo(text1.end)
                        start.linkTo(text1.start)
                    }
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 21.dp)
        ){
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_1),
                    contentDescription = null,
                    Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(16.dp)
                )
                Text(
                    text = "Inbox",
                    color = Color(android.graphics.Color.parseColor("#2e3d6d")),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_2),
                    contentDescription = null,
                    Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(16.dp)
                )
                Text(
                    text = "Maps",
                    color = Color(android.graphics.Color.parseColor("#2e3d6d")),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_3),
                    contentDescription = null,
                    Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(16.dp)
                )
                Text(
                    text = "Chats",
                    color = Color(android.graphics.Color.parseColor("#2e3d6d")),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_4),
                    contentDescription = null,
                    Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(16.dp)
                )
                Text(
                    text = "Reports",
                    color = Color(android.graphics.Color.parseColor("#2e3d6d")),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 24.dp)
        ){
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_5),
                    contentDescription = null,
                    Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(16.dp)
                )
                Text(
                    text = "Calendar",
                    color = Color(android.graphics.Color.parseColor("#2e3d6d")),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_6),
                    contentDescription = null,
                    Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(16.dp)
                )
                Text(
                    text = "Tips",
                    color = Color(android.graphics.Color.parseColor("#2e3d6d")),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_7),
                    contentDescription = null,
                    Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(16.dp)
                )
                Text(
                    text = "Settings",
                    color = Color(android.graphics.Color.parseColor("#2e3d6d")),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_8),
                    contentDescription = null,
                    Modifier.padding(top = 8.dp, bottom = 4.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(16.dp)
                )
                Text(
                    text = "More",
                    color = Color(android.graphics.Color.parseColor("#2e3d6d")),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}
