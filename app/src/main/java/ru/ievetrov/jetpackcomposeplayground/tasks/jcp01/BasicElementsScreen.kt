package ru.ievetrov.jetpackcomposeplayground.tasks.jcp01

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ievetrov.jetpackcomposeplayground.R
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-01: Базовые UI-элементы
 *
 * Задание:
 * 1. Реализовать экран с элементами: Text, Button, Image
 * 2. Продемонстрировать варианты кнопок: Button, OutlinedButton, TextButton
 * 3. Создать пример с Image и различными contentScale
 * 4. Добавить TextField для ввода текста
 * 5. Реализовать Card с составным содержимым
 */

@Composable
fun BasicElementsScreen() {
    JetpackComposePlaygroundTheme {
        val scrollState = rememberScrollState()

        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .fillMaxSize()
            ) {
                Text(
                    text = "JCP-01: Базовые UI-элементы",
                    style = MaterialTheme.typography.headlineMedium
                )

                /**
                 * ПРИМЕРЫ из урока - базовые компоненты:
                 * 
                 * // Текст
                 * Text(
                 *     text = "Заголовок",
                 *     style = MaterialTheme.typography.headlineSmall
                 * )
                 * 
                 * // Кнопка
                 * Button(onClick = { /* действие */ }) {
                 *     Text("Нажми меня")
                 * }
                 * 
                 * // Поле ввода
                 * var text by remember { mutableStateOf("") }
                 * TextField(
                 *     value = text,
                 *     onValueChange = { text = it },
                 *     label = { Text("Введите текст") }
                 * )
                 */

                // TODO 1: Реализовать экран с элементами: Text, Button, Image
                Text(
                    text = "Text example bodyMedium",
                    Modifier.padding(top = 20.dp, bottom = 10.dp),
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "Text example displayMedium",
                    Modifier.padding(top = 20.dp, bottom = 10.dp),
                    style = MaterialTheme.typography.displayMedium
                )

                Text(
                    text = "Text example headlineMedium",
                    Modifier.padding(top = 20.dp, bottom = 10.dp),
                    style = MaterialTheme.typography.headlineMedium
                )

                // TODO 2: Продемонстрировать варианты кнопок: Button, OutlinedButton, TextButton
                Button(
                    onClick = {}
                ) { Text("Button") }

                OutlinedButton(
                    onClick = {}
                ) { Text("OutlinedButton") }

                TextButton(
                    onClick = {}
                ) { Text("TextButton") }

                // TODO 3: Создать пример с Image и различными contentScale
                Image(
                    painter = painterResource(id = R.drawable.img_ervar2),
                    contentDescription = "description",
                    modifier = Modifier
                        .size(140.dp)
                        .background(Color.Gray),
                    contentScale = ContentScale.Fit
                )

                Image(
                    painter = painterResource(id = R.drawable.img_ervar2),
                    contentDescription = "description",
                    modifier = Modifier.size(140.dp),
                    contentScale = ContentScale.Crop
                )

                // TODO 4: Добавить TextField для ввода текста
                var textFieldState by remember { mutableStateOf("") }

                TextField(
                    value = textFieldState,
                    onValueChange = { newText -> textFieldState = newText },
                    placeholder = { Text("Enter text here.") },
                    modifier = Modifier
                        .fillMaxWidth()
                )

                // TODO 5: Реализовать Card с составным содержимым
                Card {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    )
                    {
                        Text(text = "Card text")

                        Button(
                            onClick = {}
                        ) {
                            Text(text = "Button card text")
                        }

                        Image(
                            painter = painterResource(id = R.drawable.img_ervar2),
                            contentDescription = "description",
                            modifier = Modifier.size(140.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                Text(
                    "Здесь будут ваши базовые UI-элементы",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BasicElementsScreenPreview() {
    BasicElementsScreen()
} 