package ru.ievetrov.jetpackcomposeplayground.tasks.jcp02

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-02: Таймер с состоянием
 *
 * Задание:
 * 1. Реализовать экран с секундомером
 * 2. Добавить кнопки "Старт", "Пауза", "Сброс"
 * 3. Отображать время в формате MM:SS.ms
 * 4. Использовать `remember` и простое состояние для времени
 */

// TODO: Создайте модель данных для состояния таймера
data class TimerState(
    val isRunning: Boolean = false,
    val elapsedTimeMillis: Long = 0L
)

// TODO: Создайте функцию для форматирования времени
fun formatTime(timeMillis: Long): String {
    val minutes = (timeMillis / 1000 / 60).toString().padStart(2, '0')
    val seconds = ((timeMillis / 1000) % 60).toString().padStart(2, '0')
    val millis = ((timeMillis % 1000) / 10).toString().padStart(2, '0')
    return "$minutes:$seconds.$millis"
}

@Composable
fun TimerScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-02: Таймер с состоянием",
                    style = MaterialTheme.typography.headlineMedium
                )
                
                // TODO 1: Реализовать экран с секундомером
                 var elapsedTime by remember { mutableLongStateOf(0L) }
                 var isRunning by remember { mutableStateOf(false) }
                
                // TODO 2: Добавить кнопки "Старт", "Пауза", "Сброс"  
                 Button(onClick = { isRunning = !isRunning }) { Text(if (isRunning) "Пауза" else "Старт") }
                 Button(onClick = { elapsedTime = 0L; isRunning = false }) { Text("Сброс") }
                
                // TODO 3: Отображать время в формате MM:SS.ms
                 Text(formatTime(elapsedTime), style = MaterialTheme.typography.headlineLarge)
                
                // TODO 4: Использовать `remember` и простое состояние для времени
                // Подсказка: LaunchedEffect для обновления каждые 10мс при isRunning = true
                LaunchedEffect(key1 = isRunning) {
                    while (isRunning) {
                        delay(10L)
                        elapsedTime += 10L
                    }
                }
                
                Text(
                    "Здесь будет ваш секундомер с кнопками управления",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TimerScreenPreview() {
    TimerScreen()
} 