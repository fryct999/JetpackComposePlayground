package ru.ievetrov.jetpackcomposeplayground.tasks.jcp02

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
// fun validateName(name: String): Boolean {
//     return name.length >= 2
// }
//
// fun validateEmail(email: String): Boolean {
//     return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
// }
//
// fun validatePassword(password: String): Boolean {
//     val hasDigit = password.any { it.isDigit() }
//     val hasSpecialChar = password.any { !it.isLetterOrDigit() }
//     return password.length >= 8 && hasDigit && hasSpecialChar
// }

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
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ValidationFormScreenPreview() {
    ValidationFormScreen()
} 