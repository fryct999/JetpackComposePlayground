package ru.ievetrov.jetpackcomposeplayground.tasks.jcp05

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


/**
 * JCP-05: Unit-тесты валидатора формы
 *
 * Задание: напиши unit-тесты для FormValidator.
 *
 * Протестируй оба метода валидатора:
 * 1. Валидный email → isValid = true
 * 2. Email без домена → isValid = false
 * 3. Email без @ → isValid = false
 * 4. Пустой email → isValid = false
 * 5. Валидное имя → isValid = true
 * 6. Короткое имя → isValid = false
 *
 * ПРИМЕР из урока RCA-48: Тест валидатора
 *
 * @Test
 * fun `valid email passes validation`() {
 *     val result = FormValidator.validateEmail("user@domain.com")
 *
 *     assertTrue(result.isValid)
 *     assertNull(result.errorMessage)
 * }
 */
class FormValidatorTest {
    @ParameterizedTest
    @MethodSource("validationEmail")
    fun `validate emails`(email: String, expectedIsValid: Boolean, expectedMessage: String?) {
        val result = FormValidator.validateEmail(email)
        assertEquals(expectedIsValid, result.isValid)
        if (expectedMessage != null) {
            val message = result.errorMessage
            assertNotNull(message)
            assertTrue(message?.contains(expectedMessage) == true)
        }
    }

    companion object {
        @JvmStatic
        fun validationEmail(): Stream<Arguments> = Stream.of(
            Arguments.of("test@test.ru", true, null),
            Arguments.of("test@", false, "Некорректный email"),
            Arguments.of("testtest.ru", false, "Некорректный email"),
            Arguments.of("", false, "Email не может быть пустым"),
        )
    }

    // TODO 5: Протестируй валидное имя (≥ 3 символов)
    // Проверь, что result.isValid = true
    @Test
    fun `valid name passes validation`() {
        val name = "Igor"
        val result = FormValidator.validateName(name)

        assertTrue(result.isValid)
        assertNull(result.errorMessage)
    }

    // TODO 6: Протестируй имя короче 3 символов
    // Проверь, что result.isValid = false и errorMessage содержит "символ"
    @Test
    fun `name too short fails validation`() {
        val name = "Ig"
        val result = FormValidator.validateName(name)

        assertFalse(result.isValid)
        assertEquals("Имя должно содержать минимум 3 символа", result.errorMessage)
    }
}