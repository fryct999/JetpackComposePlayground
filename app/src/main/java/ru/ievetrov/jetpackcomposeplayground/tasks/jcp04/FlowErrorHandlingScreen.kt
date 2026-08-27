package ru.ievetrov.jetpackcomposeplayground.tasks.jcp04

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.retryWhen
import kotlinx.coroutines.launch
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

                val scope = rememberCoroutineScope()
                val result = remember { mutableStateListOf<String>() }
                var isCollecting by remember { mutableStateOf(false) }
                var errorMessage by remember { mutableStateOf<String?>(null) }
                var job by remember { mutableStateOf<Job?>(null) }

                DisposableEffect(Unit) {
                    onDispose {
                        job?.cancel()
                    }
                }

                Button(
                    enabled = !isCollecting,
                    onClick = {
                        isCollecting = true
                        result.clear()
                        errorMessage = null
                        job = scope.launch {
                            try {
                                coroutineScope {
                                    launch {
                                        createErrorFlow()
                                            .retryWhen { cause, attempt ->
                                                if (attempt < 3) {
                                                    errorMessage = "Перезапуск попытка ${attempt + 1} из 3..."
                                                    true
                                                } else {
                                                    false
                                                }
                                            }
                                            .onCompletion { emit("Поток закрыт") }
                                            .catch { e -> errorMessage = e.message.toString() }
                                            .collect { value ->
                                            result.add(value)
                                        }
                                    }
                                }
                            } finally {
                                isCollecting = false
                            }
                        }
                    },
                ) {
                    Text("Запуск Flow")
                }

                Row {
                    LazyColumn(
                        modifier = Modifier.weight(1f)
                    ) {
                        items(result) { str ->
                            Text(str)
                        }
                    }

                    Text(
                        text = errorMessage ?: "",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

fun createErrorFlow(): Flow<String> = flow {
    emit("Пункт 1")
    delay(1000)
    emit("Пункт 2")
    delay(1000)
    throw RuntimeException("Ошибка в Flow!")
}

@Preview(showBackground = true)
@Composable
fun FlowErrorHandlingScreenPreview() {
    FlowErrorHandlingScreen()
}