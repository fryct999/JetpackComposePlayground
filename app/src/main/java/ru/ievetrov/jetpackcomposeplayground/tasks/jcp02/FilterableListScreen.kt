package ru.ievetrov.jetpackcomposeplayground.tasks.jcp02

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-02: Фильтрация списка
 *
 * Задание:
 * 1. Реализовать список элементов с фильтрацией по категориям
 * 2. Добавить чипсы-фильтры
 * 3. Обновлять отображаемый список при выборе фильтра
 * 4. Добавить кнопку сброса всех фильтров
 */

// TODO 1: Создайте перечисление для категорий
enum class ItemCategory(val displayName: String) { 
    ALL("Все"), 
    FOOD("Продукты"), 
    ELECTRONICS("Электроника"), 
    BOOKS("Книги"), 
    CLOTHES("Одежда")
}

// TODO 2: Создайте модель данных для элемента списка с категорией
data class FilterableItem(
    val id: Int,
    val title: String,
    val category: ItemCategory
)

// Тестовые данные с разными категориями
val sampleFilterableItems = listOf(
    FilterableItem(1, "Хлеб", ItemCategory.FOOD),
    FilterableItem(2, "iPhone", ItemCategory.ELECTRONICS),
    FilterableItem(3, "Война и Мир", ItemCategory.BOOKS),
    FilterableItem(4, "Молоко", ItemCategory.FOOD),
    FilterableItem(5, "Т-ширт", ItemCategory.CLOTHES),
    FilterableItem(6, "MacBook", ItemCategory.ELECTRONICS),
    FilterableItem(7, "Преступление и наказание", ItemCategory.BOOKS),
    FilterableItem(8, "Джинсы", ItemCategory.CLOTHES)
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterableListScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-02: Фильтрация списка",
                    style = MaterialTheme.typography.headlineMedium
                )
                
                // TODO 3: Реализовать список элементов с фильтрацией по категориям
                // var currentCategory by remember { mutableStateOf(ItemCategory.ALL) }
                // val filteredItems = if (currentCategory == ItemCategory.ALL) {
                //     sampleFilterableItems
                // } else {
                //     sampleFilterableItems.filter { it.category == currentCategory }
                // }
                
                // TODO 4: Добавить чипсы-фильтры
                // FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                //     ItemCategory.values().forEach { category ->
                //         FilterChip(
                //             selected = currentCategory == category,
                //             onClick = { currentCategory = category },
                //             label = { Text(category.displayName) }
                //         )
                //     }
                // }
                
                // TODO 5: Обновлять отображаемый список при выборе фильтра
                // LazyColumn {
                //     items(filteredItems) { item ->
                //         Card(
                //             modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                //         ) {
                //             Column(modifier = Modifier.padding(16.dp)) {
                //                 Text(item.title, style = MaterialTheme.typography.titleMedium)
                //                 Text(item.category.displayName, style = MaterialTheme.typography.bodySmall)
                //             }
                //         }
                //     }
                // }
                
                // TODO 6: Добавить кнопку сброса всех фильтров
                // Button(onClick = { currentCategory = ItemCategory.ALL }) {
                //     Text("Сбросить фильтры")
                // }
                
                Text(
                    "Здесь будет список с фильтрами-чипсами по категориям",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterableListScreenPreview() {
    FilterableListScreen()
} 