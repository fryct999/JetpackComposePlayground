package ru.ievetrov.jetpackcomposeplayground.tasks.jcp04

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-04: Работа с StateFlow
 *
 * Задание:
 * 1. Создать MutableStateFlow для хранения состояния формы
 * 2. Реализовать экран с полями ввода (имя, email, возраст)
 * 3. Обновлять StateFlow при изменении полей
 * 4. Добавить валидацию полей в реальном времени
 * 5. Использовать collectAsState для связи с Compose UI
 * 6. Реализовать кнопку отправки, активную только при валидных данных
 */

@Composable
fun StateFlowScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-04: Работа с StateFlow",
                    style = MaterialTheme.typography.headlineMedium
                )
                
/**
                 * ПРИМЕР из урока - работа с StateFlow:
                 * 
                 * class FormViewModel : ViewModel() {
                 *     private val _formState = MutableStateFlow(FormState())
                 *     val formState: StateFlow<FormState> = _formState.asStateFlow()
                 *     
                 *     fun updateName(name: String) {
                 *         _formState.value = _formState.value.copy(name = name)
                 *     }
                 * }
                 */
                
                // TODO 1: Создать MutableStateFlow для хранения состояния формы
                // Используйте готовый FormStateHolder класс ниже
                
                // TODO 2: Реализовать экран с полями ввода (имя, email, возраст)
                // val stateHolder: FormStateHolder = viewModel()
                // val formState by stateHolder.formState.collectAsState()
                
                // TODO 3: Обновлять StateFlow при изменении полей
                // OutlinedTextField(
                //     value = formState.name,
                //     onValueChange = { stateHolder.updateName(it) },
                //     label = { Text("Имя") }
                // )
                
                // TODO 4: Добавить валидацию полей в реальном времени
                // val isNameValid = formState.name.length >= 2
                // val isEmailValid = formState.email.contains("@")
                
                // TODO 5: Использовать collectAsState для связи с Compose UI
                // val combinedState by stateHolder.validationState.collectAsState()
                
                // TODO 6: Реализовать кнопку отправки, активную только при валидных данных
                // Button(
                //     onClick = { stateHolder.submitForm() },
                //     enabled = combinedState.isFormValid
                // ) { Text("Отправить") }
                
                Text(
                    "Здесь будет форма с StateFlow и валидацией полей",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

/**
 * ЗАГОТОВКА StateHolder класса для задания
 */

// TODO: Раскомментируйте и доработайте классы
data class FormState(
    val name: String = "",
    val email: String = "",
    val age: String = ""
)

data class ValidationState(
    val isNameValid: Boolean = false,
    val isEmailValid: Boolean = false,
    val isAgeValid: Boolean = false
) {
    val isFormValid: Boolean
        get() = isNameValid && isEmailValid && isAgeValid
}

// TODO: Раскомментируйте StateHolder класс
// class FormStateHolder : ViewModel() {
//     private val _formState = MutableStateFlow(FormState())
//     val formState: StateFlow<FormState> = _formState.asStateFlow()
//     
//     val validationState: StateFlow<ValidationState> = 
//         formState.combine(formState) { form, _ ->
//             ValidationState(
//                 isNameValid = form.name.length >= 2,
//                 isEmailValid = form.email.contains("@") && form.email.contains("."),
//                 isAgeValid = form.age.toIntOrNull()?.let { it in 18..100 } ?: false
//             )
//         }
//     
//     fun updateName(name: String) {
//         _formState.value = _formState.value.copy(name = name)
//     }
//     
//     fun updateEmail(email: String) {
//         _formState.value = _formState.value.copy(email = email)
//     }
//     
//     fun updateAge(age: String) {
//         _formState.value = _formState.value.copy(age = age)
//     }
//     
//     fun submitForm() {
//         // Логика отправки формы
//     }
// }

@Preview(showBackground = true)
@Composable
fun StateFlowScreenPreview() {
    StateFlowScreen()
}