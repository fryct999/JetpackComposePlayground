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
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoroutineLifecycleScreenPreview() {
    CoroutineLifecycleScreen()
}