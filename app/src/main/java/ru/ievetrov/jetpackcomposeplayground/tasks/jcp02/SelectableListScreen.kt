package ru.ievetrov.jetpackcomposeplayground.tasks.jcp02

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-02: Список с выбором
 *
 * Задание:
 * 1. Реализовать список элементов с чекбоксами
 * 2. Обеспечить возможность выбора каждого элемента
 * 3. Отображать количество выбранных элементов под списком
 * 4. Добавить кнопку "Выбрать все" / "Снять выбор"
 */

// TODO 1: Создайте модель данных для элемента списка с флагом выбора
data class SelectableItem(val id: Int, val title: String, var isSelected: Boolean = false)

// Тестовые данные для списка
val sampleSelectableItems = listOf(
    SelectableItem(1, "Яблоки"),
    SelectableItem(2, "Молоко"),
    SelectableItem(3, "Хлеб"),
    SelectableItem(4, "Яйца"),
    SelectableItem(5, "Масло"),
    SelectableItem(6, "Сыр")
)

// TODO 2: Создайте компонент для отображения одного элемента списка
// @Composable
// fun SelectableItemRow(
//     item: SelectableItem,
//     onCheckedChange: (Boolean) -> Unit
// ) {
//     Row(
//         modifier = Modifier.fillMaxWidth().padding(8.dp),
//         verticalAlignment = Alignment.CenterVertically
//     ) {
//         Checkbox(
//             checked = item.isSelected,
//             onCheckedChange = onCheckedChange
//         )
//         Spacer(modifier = Modifier.width(8.dp))
//         Text(item.title)
//     }
// }

@Composable
fun SelectableListScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-02: Список с выбором",
                    style = MaterialTheme.typography.headlineMedium
                )
                
                // TODO 2: Реализовать список элементов с чекбоксами
                // val items = remember { mutableStateListOf<SelectableItem>().apply { addAll(sampleSelectableItems) } }
                
                // TODO 3: Обеспечить возможность выбора каждого элемента
                // LazyColumn {
                //     items(items) { item ->
                //         SelectableItemRow(
                //             item = item,
                //             onCheckedChange = { isChecked ->
                //                 val index = items.indexOfFirst { it.id == item.id }
                //                 if (index != -1) {
                //                     items[index] = items[index].copy(isSelected = isChecked)
                //                 }
                //             }
                //         )
                //     }
                // }
                
                // TODO 4: Отображать количество выбранных элементов под списком
                // val selectedCount = items.count { it.isSelected }
                // Text("Выбрано: $selectedCount из ${items.size}")
                
                // TODO 5: Добавить кнопку "Выбрать все" / "Снять выбор"
                // val allSelected = items.all { it.isSelected }
                // Button(
                //     onClick = {
                //         val newState = !allSelected
                //         for (i in items.indices) {
                //             items[i] = items[i].copy(isSelected = newState)
                //         }
                //     }
                // ) {
                //     Text(if (allSelected) "Снять выбор" else "Выбрать все")
                // }
                
                Text(
                    "Здесь будет список с чекбоксами и счетчиком выбранных",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SelectableListScreenPreview() {
    SelectableListScreen()
} 