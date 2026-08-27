package ru.ievetrov.jetpackcomposeplayground.tasks.jcp04

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
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
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-04: Создание и сбор Flow
 *
 * Задание:
 * 1. Создать функцию, возвращающую Flow числовых значений
 * 2. Реализовать сбор значений из Flow с помощью collect
 * 3. Отображать полученные значения в LazyColumn
 * 4. Добавить кнопки для запуска и остановки сбора
 * 5. Использовать операторы трансформации (map, filter, take)
 * 6. Показывать индикатор активности Flow
 */

@Composable
fun BasicFlowScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-04: Создание и сбор Flow",
                    style = MaterialTheme.typography.headlineMedium
                )

                /**
                 * ПРИМЕР из урока - создание Flow:
                 * 
                 * fun createCounterFlow() = flow {
                 *     var count = 0
                 *     while (count < 10) {
                 *         emit(count++)
                 *         delay(1000) // раз в секунду
                 *     }
                 * }
                 * 
                 * // Использование в Compose:
                 * val count by createCounterFlow().collectAsState(initial = 0)
                 */

                // TODO 1: Создать функцию, возвращающую Flow числовых значений
                // Используйте готовые функции ниже: createNumbersFlow(), createFilteredFlow()

                // TODO 2: Реализовать сбор значений из Flow с помощью collect
//                val numbers by createNumbersFlow().collectAsState(initial = emptyList())

                // TODO 3: Отображать полученные значения в LazyColumn
//                LazyColumn {
//                    items(numbers) { number ->
//                        Text("Число: $number")
//                    }
//                }

                // TODO 4: Добавить кнопки для запуска и остановки сбора
//                var isCollecting by remember { mutableStateOf(false) }
//                Button(onClick = { isCollecting = !isCollecting }) {
//                    Text(if (isCollecting) "Остановить" else "Запустить")
//                }

                // TODO 5: Использовать операторы трансформации (map, filter, take)
//                val transformedData by createFilteredFlow()
//                    .map { "Transformed: $it" }
//                    .take(5)
//                    .collectAsState(initial = "")

                // TODO 6: Показывать индикатор активности Flow
//                if (isCollecting) {
//                    CircularProgressIndicator()
//                }

                val scope = rememberCoroutineScope()
                val numbers = remember { mutableStateListOf<Int>() }
                val stringNum = remember { mutableStateListOf<String>() }
                var isCollecting by remember { mutableStateOf(false) }
                var job by remember { mutableStateOf<Job?>(null) }

                DisposableEffect(Unit) {
                    onDispose {
                        job?.cancel()
                    }
                }

                Button(
                    onClick = {
                        if (!isCollecting) {
                            job = scope.launch {
                                try {
                                    coroutineScope {
                                        launch {
                                            createNumbersFlow().collect { number ->
                                                numbers.add(number)
                                            }
                                        }

                                        launch {
                                            createFilteredFlow()
                                                .map { "Transformed: $it" }
                                                .take(5)
                                                .collect { stringNum.add(it) }
                                        }
                                    }
                                } finally {
                                    isCollecting = false
                                }
                            }
                        } else {
                            job?.cancel()
                        }

                        isCollecting = !isCollecting
                    },
                ) {
                    Text(if (isCollecting) "Остановить" else "Запустить")
                }

                Row {
                    LazyColumn(
                        modifier = Modifier.weight(1f),
                    ) {
                        items(numbers) { number ->
                            Text("Число: $number")
                        }
                    }

                    LazyColumn(
                        modifier = Modifier.weight(1f),
                    ) {
                        items(stringNum) { str ->
                            Text(str)
                        }
                    }
                }

                if (isCollecting) {
                    CircularProgressIndicator()
                }

                Text(
                    "Здесь будет работа с Flow: создание, сбор и трансформация",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

/**
 * БАЗОВЫЕ Flow ФУНКЦИИ для задания
 */

// TODO: Раскомментируйте и доработайте Flow функции

// Простой Flow чисел
fun createNumbersFlow(): Flow<Int> = flow {
    for (i in 1..10) {
        delay(1000) // Пауза 1 секунда
        emit(i)
    }
}

// Flow с фильтрацией
fun createFilteredFlow(): Flow<Int> = flow {
    for (i in 1..20) {
        delay(500) // Пауза 0.5 секунды
        emit(i)
    }
}.filter { it % 2 == 0 } // Только четные числа

@Preview(showBackground = true)
@Composable
fun BasicFlowScreenPreview() {
    BasicFlowScreen()
}