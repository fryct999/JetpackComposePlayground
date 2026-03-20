package ru.ievetrov.jetpackcomposeplayground.tasks.jcp02

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
fun validateName(name: String): Boolean {
    return name.length >= 2
}

fun validateEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

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
                var nameState by remember { mutableStateOf("") }
                var nameErrorState by remember { mutableStateOf(false) }
                var nameSupportTextState by remember { mutableStateOf("") }

                var passState by remember { mutableStateOf("") }
                var passErrorState by remember { mutableStateOf(false) }
                var passSupportTextState by remember { mutableStateOf("") }

                var mailState by remember { mutableStateOf("") }
                var mailErrorState by remember { mutableStateOf(false) }
                var mailSupportTextState by remember { mutableStateOf("") }

                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                val isButtonEnable =
                    remember(
                        nameState,
                        passState,
                        mailState,
                        nameErrorState,
                        passErrorState,
                        mailErrorState
                    ) {
                        nameState.isNotBlank() && passState.isNotBlank() && mailState.isNotBlank() && !nameErrorState && !passErrorState && !mailErrorState
                    }

                OutlinedTextField(
                    value = nameState,
                    label = { Text("Имя пользователя") },
                    singleLine = true,
                    onValueChange = {
                        nameState = it
                        nameErrorState = !validateName(nameState) && nameState.isNotEmpty()
                        nameSupportTextState = if (nameErrorState) "Некорректный ник" else ""
                    },
                    modifier = Modifier.fillMaxWidth(),
                    isError = nameErrorState,
                    supportingText = {
                        Text(text = nameSupportTextState)
                    }
                )

                OutlinedTextField(
                    value = passState,
                    label = { Text("Пароль") },
                    singleLine = true,
                    onValueChange = {
                        passState = it
                        passErrorState = !validatePassword(passState) && passState.isNotEmpty()
                        passSupportTextState = if (passErrorState) "Некорректный пароль" else ""
                    },
                    modifier = Modifier.fillMaxWidth(),
                    isError = passErrorState,
                    supportingText = {
                        Text(text = passSupportTextState)
                    }
                )

                OutlinedTextField(
                    value = mailState,
                    label = { Text("Email адрес") },
                    singleLine = true,
                    onValueChange = {
                        mailState = it
                        mailErrorState = !validateEmail(mailState) && mailState.isNotEmpty()
                        mailSupportTextState = if (mailErrorState) "Некорректный email" else ""
                    },
                    modifier = Modifier.fillMaxWidth(),
                    isError = mailErrorState,
                    supportingText = {
                        Text(text = mailSupportTextState)
                    }
                )

                Button(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("Данные отправлены")
                        }

                        nameState = ""
                        nameErrorState = false
                        nameSupportTextState = ""
                        passState = ""
                        passErrorState = false
                        passSupportTextState = ""
                        mailState = ""
                        mailErrorState = false
                        mailSupportTextState = ""
                    },
                    enabled = isButtonEnable
                ) {
                    Text(text = "Отправить")
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