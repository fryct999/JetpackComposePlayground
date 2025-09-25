package ru.ievetrov.jetpackcomposeplayground.tasks.jcp04

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-04: Базовая работа с корутинами
 *
 * Задание:
 * 1. Создать экран с кнопкой "Запустить корутину"
 * 2. Реализовать запуск корутины с помощью LaunchedEffect и rememberCoroutineScope
 * 3. Добавить индикатор загрузки, который показывается во время работы корутины
 * 4. Использовать delay для имитации долгой операции
 * 5. После завершения корутины показать результат
 * 6. Реализовать обработку ошибок с помощью try-catch
 */

@Composable
fun BasicCoroutineScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-04: Базовая работа с корутинами",
                    style = MaterialTheme.typography.headlineMedium
                )
                
/**
                 * ПРИМЕР из урока - запуск корутин:
                 * 
                 * // 1. LaunchedEffect - привязан к жизненному циклу композиции
                 * LaunchedEffect(key1) {
                 *     fetchData() // suspend-функция
                 * }
                 * 
                 * // 2. rememberCoroutineScope - для событий пользователя
                 * val scope = rememberCoroutineScope()
                 * Button(onClick = { scope.launch { saveData() } }) {
                 *     Text("Сохранить")
                 * }
                 */
                
                // TODO 1: Создать экран с кнопкой "Запустить корутину"
                // var isLoading by remember { mutableStateOf(false) }
                // var result by remember { mutableStateOf("") }
                // val scope = rememberCoroutineScope()
                
                // TODO 2: Реализовать запуск корутины с LaunchedEffect и rememberCoroutineScope
                // Button(
                //     onClick = {
                //         scope.launch {
                //             isLoading = true
                //             result = performLongOperation()
                //             isLoading = false
                //         }
                //     }
                // ) { Text("Запустить корутину") }
                
                // TODO 3: Добавить индикатор загрузки
                // if (isLoading) {
                //     CircularProgressIndicator()
                // }
                
                // TODO 4: Использовать delay для имитации долгой операции
                // suspend fun performLongOperation(): String {
                //     delay(3000) // 3 секунды
                //     return "Операция завершена!"
                // }
                
                // TODO 5: После завершения корутины показать результат
                // if (result.isNotEmpty()) {
                //     Text(result, color = Color.Green)
                // }
                
                // TODO 6: Реализовать обработку ошибок с try-catch
                // scope.launch {
                //     try {
                //         result = performOperationWithError()
                //     } catch (e: Exception) {
                //         result = "Ошибка: ${e.message}"
                //     } finally {
                //         isLoading = false
                //     }
                // }
                
                // Используйте готовые suspend функции ниже
                
                Text(
                    "Здесь будет демонстрация LaunchedEffect и rememberCoroutineScope",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

/**
 * SUSPEND ФУНКЦИИ для задания
 */

// TODO: Раскомментируйте и используйте suspend функции

// Простая долгая операция
suspend fun performLongOperation(): String {
    delay(3000) // Имитируем загрузку 3 секунды
    return "Операция успешно завершена!"
}

// Операция с возможной ошибкой
suspend fun performOperationWithError(): String {
    delay(2000)
    if (Math.random() > 0.5) {
        throw RuntimeException("Случайная ошибка в операции")
    }
    return "Операция с риском завершена!"
}

// Операция с поэтапным прогрессом
suspend fun performStepByStepOperation(onProgress: (String) -> Unit): String {
    onProgress("Начинаем операцию...")
    delay(1000)
    
    onProgress("Выполняем шаг 1...")
    delay(1000)
    
    onProgress("Выполняем шаг 2...")
    delay(1000)
    
    onProgress("Завершаем операцию...")
    delay(500)
    
    return "Все шаги выполнены!"
}

@Preview(showBackground = true)
@Composable
fun BasicCoroutineScreenPreview() {
    BasicCoroutineScreen()
}