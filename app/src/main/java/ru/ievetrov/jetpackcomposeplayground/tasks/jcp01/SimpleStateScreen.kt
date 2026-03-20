package ru.ievetrov.jetpackcomposeplayground.tasks.jcp01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-01: Состояние в Compose
 *
 * Задание:
 * 1. Создать TextField с отображением введённого текста в реальном времени
 * 2. Использовать remember и mutableStateOf для хранения состояния текста
 * 3. Добавить переключатель (Switch), меняющий внешний вид компонента
 * 4. Реализовать чекбокс с изменением цвета текста при активации
 * 5. Продемонстрировать обновление UI при изменении любого состояния
 */

// TODO: Создайте компонент для ввода текста
@Composable
fun TextInputWithPreview(textFieldColor: Color, textColor: Color) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newText -> text = newText },
        placeholder = { Text("Enter text here.") },
        colors = TextFieldDefaults.colors(
            focusedTextColor = textFieldColor,
            unfocusedContainerColor = textFieldColor,
        ),
        textStyle = TextStyle(color = textColor, fontWeight = FontWeight.Bold),
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    )
}

// TODO: Создайте компонент переключателя темы
@Composable
fun ThemeToggle(isDarkMode: Boolean, textColor: Color, onCheckedChange: (Boolean) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(40.dp),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Switch(
            checked = isDarkMode,
            onCheckedChange = onCheckedChange
        )

        Text(text = "Dark theme", color = textColor)
    }
}

@Composable
fun SimpleStateScreen() {
    JetpackComposePlaygroundTheme {
        var isDarkMode by remember { mutableStateOf(false) }

        val bgColor = if (isDarkMode) Color.Gray else Color.White
        val textColor = if (isDarkMode) Color.DarkGray else Color.Black
        val textFieldColor = if (isDarkMode) Color.LightGray else Color.DarkGray

        Surface(
            modifier = Modifier.padding(16.dp),
            color = bgColor
        ) {
            Column {
                Text(
                    text = "JCP-01: Состояние в Compose",
                    style = MaterialTheme.typography.headlineMedium
                )

                // TODO: Используйте ваши компоненты здесь
                ThemeToggle(isDarkMode, textColor, { isDarkMode = it })
                TextInputWithPreview(textFieldColor, textColor)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleStateScreenPreview() {
    SimpleStateScreen()
} 