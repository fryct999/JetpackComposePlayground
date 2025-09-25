package ru.ievetrov.jetpackcomposeplayground.tasks.jcp01

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
// @Composable
// fun TextInputWithPreview() {
//    // var text by remember { mutableStateOf("") }
//    // Ваш код здесь
// }

// TODO: Создайте компонент переключателя темы
// @Composable
// fun ThemeToggle() {
//    // var isDarkMode by remember { mutableStateOf(false) }
//    // Ваш код здесь
// }

@Composable
fun SimpleStateScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-01: Состояние в Compose",
                    style = MaterialTheme.typography.headlineMedium
                )
                
                // TODO: Используйте ваши компоненты здесь
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleStateScreenPreview() {
    SimpleStateScreen()
} 