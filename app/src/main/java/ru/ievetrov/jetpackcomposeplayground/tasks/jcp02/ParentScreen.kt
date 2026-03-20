package ru.ievetrov.jetpackcomposeplayground.tasks.jcp02

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-02: Подъём состояния (State Hoisting) - Родительский экран
 *
 * Задание:
 * 1. Реализовать компонент-потомок с интерактивными элементами
 * 2. Вынести состояние в родительский компонент
 * 3. Передавать значение и обработчики через параметры
 * 4. Обеспечить двустороннюю связь состояний между родителем и потомком
 */

@Composable
fun ParentScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-02: Подъём состояния",
                    style = MaterialTheme.typography.headlineMedium
                )

                // TODO: Создайте состояния, которые будут подниматься от дочернего компонента
                val text = remember { mutableStateOf("") }
                val counter = remember { mutableIntStateOf(0) }
                val isEnabled = remember { mutableStateOf(true) }

                HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

                // TODO: Отображение текущих значений состояний в родительском компоненте
                Column(
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(text = "Текстовое поле: ${text.value}")
                    Text(text = "Текущий счетчик: ${counter.intValue}")
                    Text(text = "Состояние: ${if (isEnabled.value) "Включен" else "Отключен"}")
                }

                HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

                // TODO: Подключение дочернего компонента с передачей состояний
                ChildComponent(
                    value = text.value,
                    onValueChange = { text.value = it },
                    counterValue = counter.intValue,
                    onIncrementCounter = { counter.intValue++ },
                    isEnabled = isEnabled.value,
                    onToggleEnabled = { isEnabled.value = !isEnabled.value }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ParentScreenPreview() {
    ParentScreen()
} 