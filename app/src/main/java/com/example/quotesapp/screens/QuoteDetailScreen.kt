package com.example.quotesapp.screens
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quotesapp.DataManager
import com.example.quotesapp.models.Quote


@Composable
fun QuoteDetail(quote: Quote) {
    BackHandler() {
        DataManager.switchPage(null)
    }
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3),
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.padding(30.dp),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp, 16.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Image(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Quote",
                    modifier = Modifier.size(80.dp),
                    alignment = Alignment.TopStart
                )
                Text(
                    text = quote.quote,
                    style = MaterialTheme.typography.h6
                )
                Spacer(Modifier.height(16.dp))
                Text(text = quote.author, style = MaterialTheme.typography.subtitle1)
            }
        }
    }
}