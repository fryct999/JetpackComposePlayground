package ru.ievetrov.jetpackcomposeplayground.tasks.jcp02

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-02: Простое состояние кнопок
 *
 * Задание:
 * 1. Реализовать две кнопки с общим счётчиком нажатий
 * 2. Увеличивать счётчик на 1 при нажатии первой кнопки
 * 3. Уменьшать счётчик на 1 при нажатии второй кнопки
 * 4. Отображать текущее значение счётчика между кнопками
 * 5. Предотвратить возможность ухода счётчика в отрицательные значения
 */

@Composable
fun SimpleButtonsScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-02: Простое состояние кнопок",
                    style = MaterialTheme.typography.headlineMedium
                )

                // TODO 1: Реализовать две кнопки с общим счётчиком нажатий
                var clickCount by remember { mutableIntStateOf(0) }

                // TODO 2: Увеличивать счётчик на 1 при нажатии первой кнопки
                Button(
                    onClick = { clickCount += 1 },
                ) {
                    Text(text = "Увеличить счетчик")
                }

                // TODO 5: Предотвратить возможность ухода счётчика в отрицательные значения
                // TODO 3: Уменьшать счётчик на 1 при нажатии второй кнопки
                Button(
                    onClick = {
                        clickCount = if (clickCount - 1 >= 0) clickCount - 1 else 0
                    },
                ) {
                    Text(text = "Уменьшить счетчик")
                }

                // TODO 4: Отображать текущее значение счётчика между кнопками
                Text(text = "Click count: $clickCount")

                Text(
                    "Здесь будут ваши кнопки и счётчик",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleButtonsScreenPreview() {
    SimpleButtonsScreen()
} 