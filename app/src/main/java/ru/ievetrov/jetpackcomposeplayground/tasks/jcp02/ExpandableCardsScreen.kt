package ru.ievetrov.jetpackcomposeplayground.tasks.jcp02

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
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
 * JCP-02: Переключаемые карточки
 *
 * Задание:
 * 1. Реализовать список карточек с возможностью разворачивания/сворачивания
 * 2. Показывать дополнительную информацию в развёрнутом состоянии
 * 3. Анимировать переход между состояниями
 * 4. Обеспечить, чтобы одновременно была развернута только одна карточка
 */

// TODO: Создайте модель данных для карточки
data class CardItem(
    val id: Int,
    val title: String,
    val shortDescription: String,
    val fullDescription: String
)

val cardList = listOf(
    CardItem(0, "Заголовок 1", "Короткое описание 1", "Полное описание 1"),
    CardItem(1, "Заголовок 2", "Короткое описание 2", "Полное описание 2"),
    CardItem(2, "Заголовок 3", "Короткое описание 3", "Полное описание 3"),
    CardItem(3, "Заголовок 4", "Короткое описание 4", "Полное описание 4"),
    CardItem(4, "Заголовок 5", "Короткое описание 5", "Полное описание 5"),
)

// TODO: Создайте компонент для отображения карточки
@Composable
fun ExpandableCard(
    card: CardItem,
    isExpanded: Boolean,
    onCardClick: () -> Unit
) {
    Card(
        onClick = onCardClick,
        modifier = Modifier
            .padding(vertical = 5.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = card.title,
            style = MaterialTheme.typography.headlineMedium,
        )

        Text(
            text = card.shortDescription,
            style = MaterialTheme.typography.bodySmall,
        )

        AnimatedVisibility(visible = isExpanded) {
            Text(
                text = card.fullDescription,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

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

                val noExpandCardId = -1
                var cardId by remember { mutableIntStateOf(noExpandCardId) }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(15.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    userScrollEnabled = true,
                ) {
                    items(
                        items = cardList,
                        key = { it.id },
                    ) { item ->
                        val isExpanded = cardId == item.id

                        ExpandableCard(
                            card = item,
                            isExpanded = isExpanded,
                            onCardClick = {
                                cardId = if (isExpanded) noExpandCardId else item.id
                            },
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExpandableCardsScreenPreview() {
    ExpandableCardsScreen()
} 