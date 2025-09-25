package ru.ievetrov.jetpackcomposeplayground.tasks.jcp02

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-02: Подъём состояния (State Hoisting) - Компонент ребенка
 *
 * Обратите внимание: Этот компонент не должен содержать собственное состояние.
 * Вместо этого он должен принимать значение и функцию обратного вызова от родителя.
 */

@Composable
fun ChildComponent(
    // TODO: Добавьте параметры для поднятого состояния
    // value: String,
    // onValueChange: (String) -> Unit,
    // counterValue: Int,
    // onIncrementCounter: () -> Unit,
    // isEnabled: Boolean,
    // onToggleEnabled: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Компонент-потомок",
            style = MaterialTheme.typography.titleMedium
        )
        
        // TODO: Реализуйте интерфейс с использованием переданных параметров
    }
}

@Preview
@Composable
fun ChildComponentPreview() {
    JetpackComposePlaygroundTheme {
        // TODO: Раскомментируйте после реализации
        // ChildComponent(
        //     value = "Тестовое значение",
        //     onValueChange = {},
        //     counterValue = 5,
        //     onIncrementCounter = {},
        //     isEnabled = true,
        //     onToggleEnabled = {}
        // )
    }
} 