package ru.ievetrov.jetpackcomposeplayground.tasks.jcp02

import android.util.Patterns
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ru.ievetrov.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

/**
 * JCP-02: Форма ввода с валидацией
 *
 * Задание:
 * 1. Реализовать форму с полями: имя, email, пароль
 * 2. Добавить валидацию:
 *    - Имя: не пустое, минимум 2 символа
 *    - Email: соответствие формату email
 *    - Пароль: минимум 8 символов, наличие цифры и спецсимвола
 * 3. Отображать сообщения об ошибках под полями
 * 4. Активировать кнопку отправки только при валидных данных
 * 5. Показывать сообщение об успехе при успешной отправке
 */

// TODO: Создайте функции валидации для каждого поля
fun validateName(name: String): Boolean = name.length >= 2

fun validateEmail(email: String): Boolean =
    Patterns.EMAIL_ADDRESS.matcher(email).matches()

fun validatePassword(password: String): Boolean {
    val hasDigit = password.any { it.isDigit() }
    val hasSpecialChar = password.any { !it.isLetterOrDigit() }
    return password.length >= 8 && hasDigit && hasSpecialChar
}

@Composable
fun ValidationFormScreen() {
    JetpackComposePlaygroundTheme {
        Surface(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                Text(
                    text = "JCP-02: Форма с валидацией",
                    style = MaterialTheme.typography.headlineMedium
                )

                // TODO: Реализуйте задание здесь
                // Подсказка: используйте remember и mutableStateOf для хранения значений полей и состояния валидации

                var name by remember { mutableStateOf("") }
                val nameError = name.isNotEmpty() && !validateName(name)

                var email by remember { mutableStateOf("") }
                val emailError = email.isNotEmpty() && !validateEmail(email)

                var password by remember { mutableStateOf("") }
                val passwordError = password.isNotEmpty() && !validatePassword(password)

                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                val buttonValidation =
                    validateName(name) && validateEmail(email) && validatePassword(
                        password
                    )

                TextField(
                    value = name,
                    singleLine = true,
                    onValueChange = {
                        name = it
                    },
                    label = { Text(text = "Введите имя") },
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    isError = nameError,
                    supportingText = {
                        if (nameError) {
                            Text(text = "Имя должно быть длиннее 2 символов")
                        }
                    },
                )

                TextField(
                    value = email,
                    singleLine = true,
                    onValueChange = {
                        email = it
                    },
                    label = { Text(text = "Введите email") },
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    isError = emailError,
                    supportingText = {
                        if (emailError) {
                            Text(text = "Должен быть в формате электронной почты")
                        }
                    },
                )

                TextField(
                    value = password,
                    singleLine = true,
                    onValueChange = {
                        password = it
                    },
                    label = { Text(text = "Введите пароль") },
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    isError = passwordError,
                    supportingText = {
                        if (passwordError) {
                            Text(text = "Пароль должен быть не менее 8 символов, содержать спецсимвол и цифру")
                        }
                    },
                )

                Button(
                    enabled = buttonValidation,
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("Данные отправлены")
                        }

                        name = ""
                        email = ""
                        password = ""
                    }
                ) {
                    Text(
                        text = "Зарегистрироваться",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ValidationFormScreenPreview() {
    ValidationFormScreen()
} 