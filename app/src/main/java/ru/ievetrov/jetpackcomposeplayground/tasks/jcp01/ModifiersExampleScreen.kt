package ru.ievetrov.jetpackcomposeplayground.tasks.jcp01

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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
        val scrollState = rememberScrollState()

        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .fillMaxSize()
            ) {
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
                ModifiersExample(
                    text = "size padding background",
                    modifier = Modifier
                        .padding(24.dp)
                        .size(100.dp)
                        //.border(width = 4.dp, color = Color.Blue)
                        .background(Color.Red)
                )

                // TODO 2: Продемонстрировать цепочку модификаторов и порядок их применения
                // Покажите разницу: .padding().background() vs .background().padding()
                Column {
                    ModifiersExample(
                        text = "padding background",
                        modifier = Modifier
                            .padding(24.dp)
                            .size(100.dp)
                            .background(Color.Green)
                    )

                    ModifiersExample(
                        text = "background padding",
                        modifier = Modifier
                            .background(Color.Green)
                            .padding(24.dp)
                            .size(100.dp)
                    )
                }

                // TODO 3: Создать примеры с clip, border и shape
                // Пример: .clip(RoundedCornerShape(8.dp)), .border(2.dp, Color.Red)
                ModifiersExample(
                    text = "clip border",
                    modifier = Modifier
                        .padding(24.dp)
                        .size(100.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(2.dp, Color.Red)
                        .background(Color.Blue)
                )

                // TODO 4: Добавить интерактивный модификатор clickable
                // Пример: .clickable { /* действие при нажатии */ }
                // TODO 5: Показать разницу между внешним и внутренним padding
                // Подсказка: сравните .padding().background() и .background().padding()
                Column(
                    modifier = Modifier
                        .size(250.dp)
                        .background(Color.Gray)
                ) {
                    var clickCount by remember { mutableIntStateOf(0) }

                    Text(
                        text = "Inside padding. Clicks: $clickCount",
                        Modifier
                            .padding(15.dp)
                            .background(Color.Red)

                    )

                    ModifiersExample(
                        text = "Shape & outside padding",
                        modifier = Modifier
                            .padding(25.dp)
                            .size(100.dp)
                            .background(Color.Green, shape = CutCornerShape(20.dp))
                            .clickable { clickCount += 1 }
                    )
                }


                Text(
                    "Здесь будут ваши примеры модификаторов",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun ModifiersExample(text: String, modifier: Modifier = Modifier) {
    Text(text = text, modifier = modifier, textAlign = TextAlign.Center)
    //Box(modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun ModifiersExampleScreenPreview() {
    ModifiersExampleScreen()
}