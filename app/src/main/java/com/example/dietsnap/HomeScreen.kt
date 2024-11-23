package com.example.dietsnap

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(16.dp))
        TopBar()
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SetGoal(navController)
        }
        BottomBar()
    }
}

@Composable
fun TopBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Dietsnap",
            color = Color(0xFFF8B645),
            fontSize = 26.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .padding(end = 6.dp)
                    .clickable { }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
            Box(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable { }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.achievement),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }
            Box(
                modifier = Modifier
                    .padding(end = 6.dp)
                    .clickable { }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chat),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun SetGoal(navController: NavController){

    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Today",
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontSize = 26.sp
        )
        Text(
            text = "Friday, 13th Dec",
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 26.dp)
        )
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ellipseinner),
                contentDescription = null,
                modifier = Modifier.size(240.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ellipseouter),
                contentDescription = null,
                modifier = Modifier.size(190.dp)
            )
            Text(
                text = "SET GOAL!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.calories),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
            Text(
                text = "Diet Pts",
                color = Color.Black,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box {
                Image(
                    painter = painterResource(id = R.drawable.dumbell),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
            Text(
                text = "Exercise Pts",
                color = Color.Black,
                fontSize = 14.sp
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "1500",
                    color = Color(0xFFF8B645),
                    fontSize = 20.sp
                )
                Text(
                    text = "Cal",
                    fontSize = 16.sp
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "3/5",
                    color = Color(0xFFF8B645),
                    fontSize = 20.sp
                )
                Text(
                    text = "Days",
                    fontSize = 16.sp
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "88",
                    color = Color(0xFFF8B645),
                    fontSize = 20.sp,
                )
                Text(
                    text = "Health Score",
                    fontSize = 16.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(59.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Your Goals",
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Goals()
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Explore",
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Explore(navController)
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun BottomBar() {
    Column {
        HorizontalDivider()
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.activity),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clickable { }
                )
            }
            Box(
                modifier = Modifier.padding(end = 14.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.goals),
                    contentDescription = null,
                    modifier = Modifier
                        .size(85.dp)
                        .clickable { }
                )
            }
            Box(
                modifier = Modifier.padding(end = 14.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.camera),
                    contentDescription = null,
                    modifier = Modifier
                        .size(42.dp)
                        .clickable { }
                )
            }
            Box {
                Image(
                    painter = painterResource(id = R.drawable.feed),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clickable { }
                )
            }
            Box {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier
                        .size(85.dp)
                        .clickable { }
                )
            }
        }
    }
}

@Composable
fun Goals(){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(Color(0xFFEBEBEB))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "Keto weight loss plan",
                    fontSize = 20.sp
                )
                Text(
                    text = "Current Major Goal",
                    color = Color.DarkGray
                )
            }
            Spacer(modifier = Modifier.width(26.dp))
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.loading),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Text(
                    text = "73%",
                    fontSize = 8.sp
                )
            }
        }
    }
}

@Composable
fun Explore(navController: NavController){
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
                .clickable {
                    navController.navigate("FoodInfo")
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.diets),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = "Find Diets",
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Find premade diets according to your cuisine",
                    color = Color.Gray
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
                .clickable {
                    navController.navigate("FoodInfo")
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.nut),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = "Find Nutritionist",
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "get customize diets to achieve your goal",
                    color = Color.Gray
                )
            }
        }
    }
}
