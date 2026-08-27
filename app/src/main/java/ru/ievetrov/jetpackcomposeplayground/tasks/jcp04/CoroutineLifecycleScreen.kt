package ru.ievetrov.jetpackcomposeplayground.tasks.jcp04

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme
import kotlin.time.Duration.Companion.milliseconds

/**
 * JCP-04: Управление жизненным циклом корутин
 *
 * Задание:
 * 1. Реализовать таймер с помощью корутины и delay
 * 2. Добавить кнопки: Старт, Пауза, Сброс
 * 3. Использовать DisposableEffect для правильной отмены корутин
 * 4. Проверять isActive для корректной обработки отмены
 * 5. Визуально отображать состояние таймера и прогресс
 */

@Composable
fun CoroutineLifecycleScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-04: Управление жизненным циклом корутин",
                    style = MaterialTheme.typography.headlineMedium
                )

                // TODO: Реализуйте задание здесь
                // Подсказка: используйте DisposableEffect для очистки ресурсов
                // и isActive для проверки состояния корутины

                var job by remember { mutableStateOf<Job?>(null) }
                var isRunning by remember { mutableStateOf(false) }
                var seconds by remember { mutableIntStateOf(0) }
                val scope = rememberCoroutineScope()

                DisposableEffect(Unit) {
                    onDispose {
                        job?.cancel()
                    }
                }

                Row {
                    Text(
                        text = "$seconds",
                        style = MaterialTheme.typography.headlineMedium,
                    )

                    if (isRunning) {
                        CircularProgressIndicator()
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    Button(
                        onClick = {
                            if (job?.isActive != true) {
                                job = scope.launch {
                                    isRunning = true

                                    while (isActive) {
                                        delay(1000.milliseconds)
                                        seconds++
                                    }
                                }
                            }
                        }
                    ) { Text("Старт") }

                    Button(
                        onClick = {
                            job?.cancel()
                            isRunning = false
                        }
                    ) { Text("Пауза") }

                    Button(
                        onClick = {
                            job?.cancel()
                            seconds = 0
                            isRunning = false
                        }
                    ) { Text("Сброс") }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoroutineLifecycleScreenPreview() {
    CoroutineLifecycleScreen()
}