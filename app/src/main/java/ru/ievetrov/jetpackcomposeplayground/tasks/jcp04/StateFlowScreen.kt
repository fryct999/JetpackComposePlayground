package ru.ievetrov.jetpackcomposeplayground.tasks.jcp04

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
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
                // TODO 5: Использовать collectAsState для связи с Compose UI
                val stateHolder: FormStateHolder = viewModel()
                val formState by stateHolder.formState.collectAsState()
                val validationState by stateHolder.validationState.collectAsState()

                // TODO 4: Добавить валидацию полей в реальном времени
                val isNameInvalid = !validationState.isNameValid
                val isEmailInvalid = !validationState.isEmailValid
                val isAgeInvalid = !validationState.isAgeValid

                // TODO 3: Обновлять StateFlow при изменении полей
                OutlinedTextField(
                    value = formState.name,
                    onValueChange = { stateHolder.updateName(it) },
                    label = { Text("Имя") },
                    isError = formState.name.isNotEmpty() && isNameInvalid,
                )

                OutlinedTextField(
                    value = formState.email,
                    onValueChange = { stateHolder.updateEmail(it) },
                    label = { Text("Почта") },
                    isError = formState.email.isNotEmpty() && isEmailInvalid,
                )

                OutlinedTextField(
                    value = formState.age,
                    onValueChange = { stateHolder.updateAge(it) },
                    label = { Text("Возраст") },
                    isError = formState.age.isNotEmpty() && isAgeInvalid,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )

                // TODO 6: Реализовать кнопку отправки, активную только при валидных данных
                Button(
                    onClick = { stateHolder.submitForm() },
                    enabled = validationState.isFormValid
                ) { Text("Отправить") }

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
class FormStateHolder : ViewModel() {
    private val _formState = MutableStateFlow(FormState())
    val formState: StateFlow<FormState> = _formState.asStateFlow()

    val validationState: StateFlow<ValidationState> =
        formState.map {
            ValidationState(
                isNameValid = it.name.length >= 2,
                isEmailValid = it.email.contains("@") && it.email.contains("."),
                isAgeValid = it.age.toIntOrNull()?.let { it in 18..100 } ?: false
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ValidationState())

    fun updateName(name: String) {
        _formState.value = _formState.value.copy(name = name)
    }

    fun updateEmail(email: String) {
        _formState.value = _formState.value.copy(email = email)
    }

    fun updateAge(age: String) {
        _formState.value = _formState.value.copy(age = age)
    }

    fun submitForm() {
        _formState.value = FormState()
        Log.d("msg", "Форма ушла")
    }
}

@Preview(showBackground = true)
@Composable
fun StateFlowScreenPreview() {
    StateFlowScreen()
}