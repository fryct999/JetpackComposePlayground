package ru.ievetrov.jetpackcomposeplayground.tasks.jcp01

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

@Composable
fun SimpleListScreen() {
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
                // LazyColumn { ... }
                // LazyRow { ... }
                
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