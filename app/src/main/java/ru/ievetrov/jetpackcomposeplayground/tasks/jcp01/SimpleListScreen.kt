package ru.ievetrov.jetpackcomposeplayground.tasks.jcp01

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-01: Простые списки
 *
 * Задание:
 * 1. Реализовать вертикальный список с LazyColumn
 * 2. Создать горизонтальный список с LazyRow
 * 3. Добавить разные типы элементов в один список
 * 4. Продемонстрировать прокрутку и производительность списков
 */

/**
 * ПРИМЕР из урока - базовые компоненты:
 * 
 * LazyColumn {
 *     items(recipesList) { recipe ->
 *         RecipeCard(recipe)
 *     }
 * }
 * 
 * LazyRow {
 *     items(categoriesList) { category ->
 *         CategoryChip(category)
 *     }
 * }
 */

// TODO 1: Создайте модель данных для элементов списка
data class ListItem(
    val id: Int,
    val title: String,
    val subtitle: String
)

data class CategoryItem(
    val id: Int,
    val name: String,
    val color: Color
)

// TODO 2: Реализовать вертикальный список с LazyColumn
// Используйте: LazyColumn { items(list) { item -> ... } }
@Preview
@Composable
fun LazyColumnExample() {
    val list = listOf(
        ListItem(1, "Name 1", "Subtitle 1"),
        ListItem(2, "Name 2", "Subtitle 2"),
        ListItem(3, "Name 3", "Subtitle 3"),
        ListItem(4, "Name 4", "Subtitle 4"),
        ListItem(5, "Name 5", "Subtitle 5"),
    )

    Column(
        modifier = Modifier
            .height(150.dp)
            .background(Color.Gray)
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(15.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            userScrollEnabled = true,
        ) {
            items(list) { item ->
                Column {
                    Text(text = item.title)
                    Text(text = item.subtitle)
                }
            }
        }
    }
}

// TODO 3: Создать горизонтальный список с LazyRow
// Используйте: LazyRow { items(categories) { category -> ... } }
@Preview
@Composable
fun LazyRowExample() {
    val list = listOf(
        CategoryItem(1, "Name 1", Color.Black),
        CategoryItem(2, "Name 2", Color.Gray),
        CategoryItem(3, "Name 3", Color.Green),
        CategoryItem(4, "Name 4", Color.Red),
        CategoryItem(5, "Name 5", Color.Blue),
    )

    Column(
        modifier = Modifier.background(Color.Gray)
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            contentPadding = PaddingValues(15.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            userScrollEnabled = true,
        ) {
            items(list) { item ->
                Text(text = item.name, modifier = Modifier.background(item.color))
            }
        }
    }
}

// TODO 4: Добавить разные типы элементов в один список
// Подсказка: используйте when для различных типов UI
@Preview
@Composable
fun DifferentItemExample() {
    val list = listOf(
        ListItem(1, "Name 1", "Subtitle 1"),
        ListItem(2, "Name 2", "Subtitle 2"),
        ListItem(3, "Name 3", "Subtitle 3"),
        ListItem(4, "Name 4", "Subtitle 4"),
        ListItem(5, "Name 5", "Subtitle 5"),
    )

    val listCategory = listOf(
        CategoryItem(1, "Name 1", Color.Black),
        CategoryItem(2, "Name 2", Color.Gray),
        CategoryItem(3, "Name 3", Color.Green),
        CategoryItem(4, "Name 4", Color.Red),
        CategoryItem(5, "Name 5", Color.Blue),
    )

    Column(
        modifier = Modifier.background(Color.Gray)
    ) {
        LazyColumn {
            item {
                Text(text = "Заголовок", modifier = Modifier.background(Color.Yellow))
            }

            items(list) { item ->
                Column {
                    Text(text = item.title)
                    Text(text = item.subtitle)
                }
            }

            item {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    contentPadding = PaddingValues(15.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    userScrollEnabled = true,
                ) {
                    items(listCategory) { item ->
                        Text(text = item.name, modifier = Modifier.background(item.color))
                    }
                }
            }
        }
    }
}

@Composable
fun SimpleListScreen() {
    val listItem = listOf(
        ListItem(1, "Name 1", "Subtitle 1"),
        ListItem(2, "Name 2", "Subtitle 2"),
        ListItem(3, "Name 3", "Subtitle 3"),
        ListItem(4, "Name 4", "Subtitle 4"),
        ListItem(5, "Name 5", "Subtitle 5"),
    )

    val listCategory = listOf(
        CategoryItem(1, "Name 1", Color.Black),
        CategoryItem(2, "Name 2", Color.Gray),
        CategoryItem(3, "Name 3", Color.Green),
        CategoryItem(4, "Name 4", Color.Red),
        CategoryItem(5, "Name 5", Color.Blue),
    )

    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-01: Простые списки",
                    style = MaterialTheme.typography.headlineMedium
                )

                // После выполнения заданий 1-4, добавьте ваши списки здесь:
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(15.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    userScrollEnabled = true,
                ) {
                    items(listItem) { item ->
                        Column {
                            Text(text = item.title)
                            Text(text = item.subtitle)
                        }
                    }
                }

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    contentPadding = PaddingValues(15.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    userScrollEnabled = true,
                ) {
                    items(listCategory) { item ->
                        Text(text = item.name, modifier = Modifier.background(item.color))
                    }
                }

                Text(
                    "Здесь будут ваши LazyColumn и LazyRow списки",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleListScreenPreview() {
    SimpleListScreen()
}