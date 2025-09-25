package ru.ievetrov.jetpackcomposeplayground.tasks.jcp02

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
 * JCP-02: Переключаемые карточки
 *
 * Задание:
 * 1. Реализовать список карточек с возможностью разворачивания/сворачивания
 * 2. Показывать дополнительную информацию в развёрнутом состоянии
 * 3. Анимировать переход между состояниями
 * 4. Обеспечить, чтобы одновременно была развернута только одна карточка
 */

// TODO: Создайте модель данных для карточки
// data class CardItem(
//     val id: Int,
//     val title: String,
//     val shortDescription: String,
//     val fullDescription: String
// )

// TODO: Создайте компонент для отображения карточки
// @Composable
// fun ExpandableCard(
//     card: CardItem,
//     isExpanded: Boolean,
//     onCardClick: () -> Unit
// ) {
//     // Ваш код здесь
// }

@Composable
fun ExpandableCardsScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-02: Переключаемые карточки",
                    style = MaterialTheme.typography.headlineMedium
                )
                
                // TODO: Реализуйте задание здесь
                // Подсказка: используйте remember { mutableStateOf(-1) } для хранения ID развернутой карточки
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExpandableCardsScreenPreview() {
    ExpandableCardsScreen()
} 