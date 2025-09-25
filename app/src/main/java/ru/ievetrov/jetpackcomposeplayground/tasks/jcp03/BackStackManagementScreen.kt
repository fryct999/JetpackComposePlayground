package ru.ievetrov.jetpackcomposeplayground.tasks.jcp03

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-03: Управление бэкстеком
 *
 * Задание:
 * 1. Реализовать последовательность из 4-5 экранов
 * 2. Добавить навигационные кнопки разных типов:
 *   - Стандартный переход вперёд
 *   - Возврат назад
 *   - Переход на главный экран с очисткой всего бэкстека
 *   - Переход к конкретному экрану с очисткой промежуточных
 * 3. Отображать текущее состояние бэкстека на экране
 * 4. Продемонстрировать различные стратегии управления бэкстеком с опциями popUpTo, inclusive, launchSingleTop
 */

@Composable
fun BackStackManagementScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-03: Управление бэкстеком",
                    style = MaterialTheme.typography.headlineMedium
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // TODO: Реализуйте управление бэкстеком
                // Пример структуры экрана:
                
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Демонстрация управления бэкстеком",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Text(
                        text = "Текущий экран: Начальный",
                        style = MaterialTheme.typography.titleMedium
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        text = "Состояние бэкстека: []",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Button(
                        onClick = { /* Стандартный переход на следующий экран */ },
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        Text("Перейти на экран 1")
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Button(
                        onClick = { /* Переход с popUpTo */ },
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        Text("Перейти на экран 3 (очистив промежуточные)")
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Button(
                        onClick = { /* Переход с popUpTo и inclusive */ },
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        Text("Вернуться на главный экран")
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Button(
                        onClick = { /* Возврат назад */ },
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        Text("Назад")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BackStackManagementScreenPreview() {
    BackStackManagementScreen()
} 