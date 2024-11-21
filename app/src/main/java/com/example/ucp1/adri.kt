
package com.example.ucp1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {
    var origin by remember { mutableStateOf("") }
    var departure by remember { mutableStateOf("") }
    var arrival by remember { mutableStateOf("") }
    var selectedTransport by remember { mutableStateOf("") }

    val transportOptions = listOf("Bus", "Ship", "Train", "Plane")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF4CAF50))
            .padding(10.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.snow),
                    contentDescription = "Snow Image",
                    modifier = Modifier.size(100.dp)
                )
                Text(
                    text = "RRQ Snow",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Input Fields
            TextField(
                value = origin,
                onValueChange = { origin = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                label = { Text("Origin") },
                placeholder = { Text("Enter origin location") }
            )

            TextField(
                value = departure,
                onValueChange = { departure = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                label = { Text("Departure") },
                placeholder = { Text("Enter departure time") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            TextField(
                value = arrival,
                onValueChange = { arrival = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                label = { Text("Arrival") },
                placeholder = { Text("Enter arrival time") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Radio Button for Transport Selection
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Choose Transportation", fontWeight = FontWeight.Bold)
                transportOptions.forEach { transport ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectedTransport == transport,
                            onClick = { selectedTransport = transport }
                        )
                        Text(text = transport)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Save Button
            Button(onClick = { /* Logic to save data */ }, modifier = Modifier.padding(10.dp)) {
                Text(text = "Save")
            }

            // Display Saved Data
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    TampilData("Origin", origin)
                    TampilData("Departure", departure)
                    TampilData("Arrival", arrival)
                    TampilData("Transport", selectedTransport)
                }
            }
        }
    }
}

@Composable
fun TampilData(param: String, argu: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = param, fontWeight = FontWeight.Bold)
        Text(text = ":")
        Text(text = argu)
    }
}
