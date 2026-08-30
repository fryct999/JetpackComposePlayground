package ru.ievetrov.jetpackcomposeplayground.tasks.jcp05

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.compose.node.element.ComposeScreen.Companion.onComposeScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.ievetrov.jetpackcomposeplayground.MainActivity
import ru.ievetrov.screen.ProductsComposeScreen

/**
 * JCP-05: Практика написания тестов — Kaspresso-тест (задание 6, дополнительное)
 *
 * Задание: написать end-to-end тест экрана продуктов с помощью Kaspresso.
 *
 * В отличие от ComposeTestRule, здесь запускается настоящая активность
 * с реальной навигацией. Каждый шаг теста обёрнут в step(), что делает
 * отчёт о падении наглядным: скриншот + имя шага, где произошла ошибка.
 *
 * Ориентируйтесь на урок RCA-52.
 *
 * Что нужно сделать:
 * 1. Запустить MainActivity с помощью activityScenarioRule
 * 2. В первом тесте: перейти к экрану продуктов, проверить что он открылся
 * 3. Во втором тесте: ввести текст в поле поиска, проверить фильтрацию
 * 4. Каждое логическое действие оборачивайте в step("описание") { }
 *
 * ПРИМЕР из урока RCA-52: структура Kaspresso-теста
 *
 * class SampleKaspressoTest : TestCase() {
 *
 *     @get:Rule
 *     val activityRule = activityScenarioRule<MainActivity>()
 *
 *     @Test
 *     fun shouldShowMainScreen() = run {
 *         step("Проверить заголовок главного экрана") {
 *             onView(withText("JetpackComposePlayground"))
 *                 .check(matches(isDisplayed()))
 *         }
 *         step("Нажать на карточку JCP-05") {
 *             onView(withText("Тестирование экрана продуктов"))
 *                 .perform(click())
 *         }
 *     }
 * }
 */
@RunWith(AndroidJUnit4::class)
class KaspressoProductsTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.withComposeSupport()
) {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    /**
     * Тест 1: Экран продуктов открывается при запуске
     *
     * Шаги:
     * 1. Запускается MainActivity (автоматически через activityRule)
     * 2. Находим карточку "Тестирование экрана продуктов" на главном экране
     * 3. Нажимаем на неё
     * 4. Проверяем что открылся экран с тегом "products_screen"
     */

    @Test
    fun shouldDisplayProductsScreenOnLaunch() = run {
        step("Открыть экран продуктов") {
            composeTestRule
                .onNodeWithText("Тестирование экрана продуктов")
                .performScrollTo()

            composeTestRule
                .onNodeWithText("Тестирование экрана продуктов")
                .performClick()
        }

        step("Проверить что экран продуктов открылся") {
            // Проверяем конкретные элементы вместо всего экрана
            onComposeScreen<ProductsComposeScreen>(composeTestRule) {
                searchField { assertIsDisplayed() }
                loadingIndicator { assertIsNotDisplayed() }

                assertIsDisplayed()
            }
        }
    }

    /**
     * Тест 2: Поиск фильтрует список продуктов
     *
     * Шаги:
     * 1. Открываем экран продуктов (как в тесте 1)
     * 2. Находим поле поиска по тегу "search_field"
     * 3. Вводим текст поиска
     * 4. Проверяем что совпадающий продукт виден, а несовпадающий — нет
     */
    @Test
    fun shouldFilterProductsBySearch() = run {
        val product = "Молоко"

        step("Открыть экран продуктов") {
            // TODO: нажмите на карточку "Тестирование экрана продуктов" в MainScreen
            composeTestRule
                .onNodeWithText("Тестирование экрана продуктов")
                .performScrollTo()

            composeTestRule
                .onNodeWithText("Тестирование экрана продуктов")
                .performClick()
        }

        // TODO 3: Ввести текст в поле поиска
        // Подсказка: onView(withTagValue(equalTo("search_field")))
        //     .perform(typeText("Молоко"), closeSoftKeyboard())
        step("Ввести запрос в поиск") {
            // TODO: найдите поле с тегом "search_field" и введите текст
            onComposeScreen<ProductsComposeScreen>(composeTestRule) {
                loadingIndicator { assertIsNotDisplayed() }
                searchField {
                    assertIsDisplayed()
                    performTextInput(product)
                }
            }
        }

        // TODO 4: Проверить результаты фильтрации
        // Подсказка: onView(withText("Молоко")).check(matches(isDisplayed()))
        //            onView(withText("Хлеб")).check(doesNotExist())
        step("Проверить отфильтрованные продукты") {
            // TODO: проверьте что нужный продукт виден, а остальные скрыты
            onComposeScreen<ProductsComposeScreen>(composeTestRule) {
                productList { assertIsDisplayed() }

                milk { assertIsDisplayed() }
                bread { assertDoesNotExist() }
            }
        }
    }
}