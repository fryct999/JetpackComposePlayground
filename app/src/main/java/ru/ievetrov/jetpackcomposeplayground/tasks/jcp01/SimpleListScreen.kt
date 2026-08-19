package ru.ievetrov.jetpackcomposeplayground.tasks.jcp01

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.remember
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
// data class ListItem(val id: Int, val title: String, val subtitle: String)
// data class CategoryItem(val id: Int, val name: String, val color: Color)

// TODO 2: Реализовать вертикальный список с LazyColumn
// Используйте: LazyColumn { items(list) { item -> ... } }

// TODO 3: Создать горизонтальный список с LazyRow
// Используйте: LazyRow { items(categories) { category -> ... } }

// TODO 4: Добавить разные типы элементов в один список
// Подсказка: используйте when для различных типов UI

data class ListItem(
    val id: Int,
    val title: String,
    val subtitle: String,
) : DifferentData()

data class CategoryItem(
    val id: Int,
    val name: String,
    val color: Color,
) : DifferentData()

sealed class DifferentData

@Composable
fun SimpleListScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.padding(5.dp),
            ) {
                Text(
                    text = "JCP-01: Простые списки",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    "Здесь будут ваши LazyColumn и LazyRow списки",
                    style = MaterialTheme.typography.bodyMedium
                )

                val colorList = listOf(Color.Red, Color.Blue, Color.Yellow)
                val listOfListItems = remember {
                    buildList {
                        repeat(50) { i ->
                            add(ListItem(i + 1, "${i + 1} ListItem", "Описание ${i + 1}"))
                        }
                    }
                }

                val listOfCategoryItem = remember {
                    buildList {
                        repeat(50) { i ->
                            add(CategoryItem(i + 1, "${i + 1} CategoryItem", colorList.random()))
                        }
                    }
                }

                val listOfDifferentData = remember {
                    buildList {
                        repeat(20) {
                            add(listOf(listOfListItems, listOfCategoryItem).random().random())
                        }
                    }
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp),
                )

                LazyColumnExample(listOfListItems)

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp),
                )

                LazyRowExample(listOfCategoryItem)

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp),
                )

                DifferentItem(listOfDifferentData)
            }
        }
    }
}

@Composable
fun LazyColumnExample(items: List<ListItem>) {
    LazyColumn(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth(),
    ) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .padding(5.dp),
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyMedium,
                )

                Text(
                    text = item.subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

@Composable
fun LazyRowExample(categories: List<CategoryItem>) {
    LazyRow(
        modifier = Modifier
            .padding(5.dp)
            .height(100.dp),
    ) {
        items(categories) { item ->
            Text(
                text = item.name,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(5.dp)
                    .background(item.color),
            )
        }
    }
}

@Composable
fun DifferentItem(
    items: List<DifferentData>,
) {
    Column(
        modifier = Modifier
            .height(500.dp)
            .background(Color.Gray),
    ) {
        LazyColumn {
            items(items) { item ->
                when (item) {
                    is ListItem -> Row(
                        modifier = Modifier
                            .padding(5.dp),
                    ) {
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.bodyMedium,
                        )

                        Text(
                            text = item.subtitle,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }

                    is CategoryItem -> Text(
                        text = item.name,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .padding(5.dp)
                            .background(item.color),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleListScreenPreview() {
    SimpleListScreen()
} 