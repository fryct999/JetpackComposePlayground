package ru.ievetrov.jetpackcomposeplayground.tasks.jcp04

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
 * JCP-04: Обработка ошибок в Flow
 *
 * Задание:
 * 1. Создать Flow, который генерирует ошибку в процессе работы
 * 2. Реализовать обработку ошибок с помощью catch
 * 3. Добавить оператор retry для повторных попыток
 * 4. Использовать onCompletion для отслеживания завершения
 * 5. Отображать состояние потока и ошибки в UI
 * 6. Реализовать возможность перезапуска потока после ошибки
 */

@Composable
fun FlowErrorHandlingScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-04: Обработка ошибок в Flow",
                    style = MaterialTheme.typography.headlineMedium
                )
                
                // TODO: Реализуйте задание здесь
                // Подсказка: используйте .catch { } для обработки ошибок
                // и .retry(times) для повторных попыток
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlowErrorHandlingScreenPreview() {
    FlowErrorHandlingScreen()
}