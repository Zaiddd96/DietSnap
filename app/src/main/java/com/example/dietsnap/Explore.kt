package com.example.dietsnap

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.example.dietsnap.data.RecipeResponse
import com.example.dietsnap.utils.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun FoodInfo(navController: NavController) {
    var foodInfo by remember { mutableStateOf<RecipeResponse?>(null) }
    var errorMessage by remember { mutableStateOf<String>("") }
    var isLoading by remember { mutableStateOf(true) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.getFoodInfo()
                foodInfo = response
            } catch (e: Exception) {
                errorMessage = "Failed: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }
    if (isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }
    }  else if (errorMessage.isNotEmpty()) {
        Text(text = "Error: $errorMessage")
    } else{

        Column{
            foodInfo?.let { Biryani(foodInfo = it, navController) }
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Description",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                foodInfo?.data?.let {
                    Text(
                        text = "Chicken Biryani is a ${it.description}",
                        textAlign = TextAlign.Justify,
                        fontSize = 13.sp,
                        color = Color.DarkGray,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(start = 16.dp, end = 20.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Macro Nutrients",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
                foodInfo?.let { NutritionTable(foodInfo = it) }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Facts",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
                foodInfo?.let { Facts(foodInfo = it) }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Similar Items",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
                foodInfo?.let { SimilarItem(foodInfo = it) }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }

}

@Composable
fun Biryani(foodInfo: RecipeResponse, navController: NavController){
    Box{
        Image(
            painter = painterResource(id = R.drawable.biryani),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                Modifier.size(16.dp),
                tint = Color.White
            )
            Text(
                text = "Back",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.W300,
                    modifier = Modifier.clickable {
                        navController.navigate("HomeScreen")
                    }
            )
        }
        Column(
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Text(
                text = "Food Information",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 14.dp)
            )
            Text(
                text = foodInfo.data.name,
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(14.dp)
            )

        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun NutritionTable(foodInfo:RecipeResponse){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp, end = 40.dp, top = 36.dp)
            .background(
                Color(0x66F4E1C1),
                shape = RoundedCornerShape(8.dp)
            )
            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Nutrients",
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Per Serve",
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Unit",
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.SemiBold
            )
        }
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        val data = foodInfo.data.nutrition_info_scaled.take(6)
        data.forEach { item->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.name,
                    modifier = Modifier.weight(1f),
                    fontWeight = FontWeight.SemiBold
                )
                val roundedValue = String.format("%.2f", item.value)
                Text(
                    text = roundedValue,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.DarkGray
                )

                Text(
                    text = item.units,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun Facts(foodInfo: RecipeResponse) {
    LazyRow(
        modifier = Modifier.padding(16.dp)
    ) {
        val facts = foodInfo.data.generic_facts
        items(facts) { fact ->
            Card(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .width(250.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF9C66A)
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "Did You Know?",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = fact,
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Composable
fun SimilarItem(foodInfo: RecipeResponse) {
    LazyRow(
        modifier = Modifier.padding(16.dp)
    ) {
        val items = foodInfo.data.similar_items
        items(items) { item ->
            Card(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .width(250.dp),
                shape = RoundedCornerShape(12.dp),
            ) {
                Box {
                    SubcomposeAsyncImage(
                        model = item.image,
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = item.name,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        color = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(6.dp)
                    )
                }
            }
        }
    }
}

