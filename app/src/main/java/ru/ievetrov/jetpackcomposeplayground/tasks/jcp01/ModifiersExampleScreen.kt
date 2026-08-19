package ru.ievetrov.jetpackcomposeplayground.tasks.jcp01

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-01: Работа с модификаторами
 *
 * Задание:
 * 1. Реализовать примеры основных модификаторов (size, padding, background)
 * 2. Продемонстрировать цепочку модификаторов и порядок их применения
 * 3. Создать примеры с clip, border и shape
 * 4. Добавить интерактивный модификатор clickable
 * 5. Показать разницу между внешним и внутренним padding
 */

@Composable
fun ModifiersExampleScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-01: Работа с модификаторами",
                    style = MaterialTheme.typography.headlineMedium
                )

                /**
                 * ПРИМЕР из урока - цепочка модификаторов:
                 * 
                 * Text(
                 *     text = "Стильный текст",
                 *     modifier = Modifier
                 *         .padding(16.dp)           // Внешние отступы
                 *         .background(Color.Gray)   // Фон
                 *         .padding(8.dp)           // Внутренние отступы
                 *         .fillMaxWidth()          // На всю ширину
                 * )
                 */

                // TODO 1: Реализовать примеры основных модификаторов (size, padding, background)
                // Пример: .size(100.dp), .padding(16.dp), .background(Color.Blue)

                // TODO 2: Продемонстрировать цепочку модификаторов и порядок их применения
                // Покажите разницу: .padding().background() vs .background().padding()

                // TODO 3: Создать примеры с clip, border и shape
                // Пример: .clip(RoundedCornerShape(8.dp)), .border(2.dp, Color.Red)

                // TODO 4: Добавить интерактивный модификатор clickable
                // Пример: .clickable { /* действие при нажатии */ }

                // TODO 5: Показать разницу между внешним и внутренним padding
                // Подсказка: сравните .padding().background() и .background().padding()

                Text(
                    text = "Здесь будут ваши примеры модификаторов",
                    style = MaterialTheme.typography.bodyMedium,
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp),
                )

                Text(
                    text = "Пример size, padding, background",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(16.dp)
                        .background(Color.Blue),
                    style = MaterialTheme.typography.bodyMedium,
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp),
                )

                Row {
                    Text(
                        text = "Пример padding, background",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(16.dp)
                            .background(Color.Blue),
                        style = MaterialTheme.typography.bodyMedium,
                    )

                    Text(
                        text = "Пример background, padding",
                        modifier = Modifier
                            .size(100.dp)
                            .background(Color.Blue)
                            .padding(16.dp),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp),
                )

                Row {
                    Text(
                        text = "Пример с clip",
                        modifier = Modifier
                            .padding(16.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .size(100.dp)
                            .background(Color.Blue)
                            .padding(16.dp),
                        style = MaterialTheme.typography.bodyMedium,
                    )

                    Text(
                        text = "Пример с border",
                        modifier = Modifier
                            .padding(16.dp)
                            .border(2.dp, Color.Red)
                            .size(100.dp)
                            .background(Color.Blue)
                            .padding(16.dp),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp),
                )

                var clickCount by rememberSaveable { mutableIntStateOf(0) }

                Text(
                    text = "Пример с clickable. ClickCount - $clickCount",
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable { clickCount++ }
                        .size(150.dp)
                        .background(Color.Blue)
                        .padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ModifiersExampleScreenPreview() {
    ModifiersExampleScreen()
} 