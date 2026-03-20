package ru.ievetrov.jetpackcomposeplayground.tasks.jcp02

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ievetrov.jetpackcomposeplayground.R
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
            .padding(2.dp)
            .width(180.dp),
    ) {
        Text(
            modifier = Modifier.padding(4.dp),
            text = card.title
        )

        AnimatedVisibility(visible = !isExpanded) {
            Text(
                modifier = Modifier.padding(4.dp),
                text = card.shortDescription
            )
        }

        AnimatedVisibility(visible = isExpanded) {
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                Text(card.fullDescription)
                Image(
                    painter = painterResource(id = R.drawable.img_ervar2),
                    contentDescription = "description",
                    modifier = Modifier
                        .size(140.dp),
                    contentScale = ContentScale.None
                )
            }
        }
    }
}

@Composable
fun ExpandableCardsScreen() {
    JetpackComposePlaygroundTheme {
        val items = List(5) { "Position №${it + 1}" }
        var expandedCardIndex by remember { mutableIntStateOf(-1) }

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
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(15.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    userScrollEnabled = true,
                ) {
                    items(items.size) { id ->
                        val isExpanded = expandedCardIndex == id

                        ExpandableCard(
                            card = CardItem(
                                id = id,
                                title = items[id],
                                shortDescription = "Короткое описание",
                                fullDescription = "Развернутое описание"
                            ),
                            isExpanded = isExpanded,
                            onCardClick = {
                                expandedCardIndex = if (isExpanded) -1 else id
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