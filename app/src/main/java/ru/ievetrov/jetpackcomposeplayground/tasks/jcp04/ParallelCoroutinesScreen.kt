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
 * JCP-04: Параллельные операции
 *
 * Задание:
 * 1. Создать экран с кнопкой "Загрузить данные"
 * 2. Реализовать загрузку из двух разных источников с использованием async/await
 * 3. Отображать индикаторы загрузки для каждого источника
 * 4. Использовать coroutineScope для структурированной конкуррентности
 * 5. Показывать объединенный результат после загрузки обоих источников
 * 6. Добавить визуализацию времени выполнения каждой операции
 */

@Composable
fun ParallelCoroutinesScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-04: Параллельные операции",
                    style = MaterialTheme.typography.headlineMedium
                )
                
                // TODO: Реализуйте задание здесь
                // Подсказка: используйте async { } для параллельного выполнения
                // и await() для ожидания результатов
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ParallelCoroutinesScreenPreview() {
    ParallelCoroutinesScreen()
}