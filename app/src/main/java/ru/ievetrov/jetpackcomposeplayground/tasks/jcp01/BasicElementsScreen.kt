package ru.ievetrov.jetpackcomposeplayground.tasks.jcp01

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
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
                // Создайте различные Text с разными style
                
                // TODO 2: Продемонстрировать варианты кнопок: Button, OutlinedButton, TextButton
                // Покажите различия в стилях кнопок
                
                // TODO 3: Создать пример с Image и различными contentScale
                // Пример: Image(painterResource(R.drawable.sample), contentScale = ContentScale.Crop)
                // Попробуйте: ContentScale.Fit, ContentScale.FillWidth, ContentScale.Inside
                
                // TODO 4: Добавить TextField для ввода текста
                // Используйте: var text by remember { mutableStateOf("") }
                
                // TODO 5: Реализовать Card с составным содержимым
                // Card { Column { Text() + Button() + Image() } }
                
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