package ru.ievetrov.jetpackcomposeplayground.tasks.jcp04

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme
import kotlin.system.measureTimeMillis

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

                var isLoadingFirst by remember { mutableStateOf(false) }
                var isLoadingSecond by remember { mutableStateOf(false) }
                var result by remember { mutableStateOf("") }
                var firstTime by remember { mutableLongStateOf(0L) }
                var secondTime by remember { mutableLongStateOf(0L) }
                val scope = rememberCoroutineScope()

                Button(
                    enabled = !isLoadingFirst && !isLoadingSecond,
                    onClick = {
                        scope.launch {
                            isLoadingFirst = true
                            isLoadingSecond = true

                            try {
                                coroutineScope {
                                    val firstData = async {
                                        var data = ""
                                        val time = measureTimeMillis { data = loadFirstData() }
                                        isLoadingFirst = false
                                        firstTime = time
                                        data
                                    }

                                    val secondData = async {
                                        var data = ""
                                        val time = measureTimeMillis { data = loadSecondData() }
                                        isLoadingSecond = false
                                        secondTime = time
                                        data
                                    }

                                    result = firstData.await() + secondData.await()
                                }
                            } catch (e: CancellationException) {
                                throw e
                            } catch (e: Exception) {
                                result = "Ошибка: ${e.message}"
                            } finally {
                                isLoadingFirst = false
                                isLoadingSecond = false
                            }
                        }
                    },
                ) { Text("Загрузить данные") }

                if (isLoadingFirst) {
                    CircularProgressIndicator()
                } else {
                    Text("Время первой операции: $firstTime")
                }

                if (isLoadingSecond) {
                    CircularProgressIndicator()
                } else {
                    Text("Время второй операции: $secondTime")
                }

                Text("Результат: $result")
            }
        }
    }
}

suspend fun loadFirstData(): String {
    delay(4000)
    return "Операция завершена!"
}

suspend fun loadSecondData(): String {
    delay(2000)
    return "Операция завершена!"
}

@Preview(showBackground = true)
@Composable
fun ParallelCoroutinesScreenPreview() {
    ParallelCoroutinesScreen()
}