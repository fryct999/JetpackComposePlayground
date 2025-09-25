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
 * JCP-04: События с SharedFlow
 *
 * Задание:
 * 1. Создать MutableSharedFlow для событий приложения
 * 2. Реализовать разные типы событий (сообщение, ошибка, навигация)
 * 3. Добавить кнопки для эмиссии различных событий
 * 4. Использовать LaunchedEffect для сбора событий
 * 5. Показывать Snackbar или диалог в зависимости от типа события
 * 6. Реализовать возможность отмены действия
 */

@Composable
fun SharedFlowScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-04: События с SharedFlow",
                    style = MaterialTheme.typography.headlineMedium
                )
                
                // TODO: Реализуйте задание здесь
                // Подсказка: используйте MutableSharedFlow для событий
                // и LaunchedEffect для сбора в Compose
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SharedFlowScreenPreview() {
    SharedFlowScreen()
}