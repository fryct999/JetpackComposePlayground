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
 * JCP-03: Deep Links
 *
 * Задание:
 * 1. Реализовать экран с демонстрацией deepLinks
 * 2. Настроить обработку deepLinks для нескольких экранов
 * 3. Создать кнопки для имитации открытия deepLinks
 * 4. Добавить поддержку передачи параметров через deepLinks
 * 5. Продемонстрировать работу с явными и неявными deepLinks
 */

@Composable
fun DeepLinksScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-03: Deep Links",
                    style = MaterialTheme.typography.headlineMedium
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // TODO: Реализуйте работу с Deep Links
                // Пример структуры экрана:
                
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Демонстрация Deep Links в Jetpack Navigation",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Button(
                        onClick = { /* Имитация открытия deepLink */ },
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        Text("Открыть страницу товара")
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Button(
                        onClick = { /* Имитация открытия deepLink с параметрами */ },
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        Text("Открыть с параметрами")
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Button(
                        onClick = { /* Имитация открытия неявного deepLink */ },
                        modifier = Modifier.fillMaxWidth(0.8f)
                    ) {
                        Text("Неявный Deep Link")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DeepLinksScreenPreview() {
    DeepLinksScreen()
} 