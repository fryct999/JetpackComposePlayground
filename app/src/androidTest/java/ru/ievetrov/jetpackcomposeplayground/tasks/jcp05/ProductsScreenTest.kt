package ru.ievetrov.jetpackcomposeplayground.tasks.jcp05

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

/**
 * JCP-05: Compose UI-тесты экрана продуктов
 *
 * Задание: напиши UI-тесты для ProductsScreen.
 *
 * Протестируй отображение экрана в разных состояниях:
 * 1. Отображение списка из нескольких продуктов (названия видны)
 * 2. Отображение индикатора загрузки при isLoading = true
 * 3. Отображение пустого состояния при products = emptyList()
 * 4. Поиск фильтрует отображаемые продукты
 * 5. Клик по продукту вызывает колбэк onProductClick
 *
 * ПРИМЕР из урока RCA-50: Compose UI тест
 *
 * @Test
 * fun displaysProductList() {
 *     composeRule.setContent {
 *         ProductsScreen(
 *             uiState = ProductsUiState(
 *                 products = listOf(
 *                     ProductUiModel(1, "Молоко", "89.9", ""),
 *                     ProductUiModel(2, "Хлеб", "49.9", "")
 *                 )
 *             )
 *         )
 *     }
 *
 *     composeRule
 *         .onNodeWithTag("product_list")
 *         .assertExists()
 *
 *     composeRule
 *         .onNodeWithText("Молоко")
 *         .assertIsDisplayed()
 *
 *     composeRule
 *         .onNodeWithText("Хлеб")
 *         .assertIsDisplayed()
 * }
 */
class ProductsScreenTest {
    @get:Rule
    val composeRule = createComposeRule()

    // TODO 1: Протестируй отображение списка продуктов
    // Подставь uiState с несколькими продуктами и проверь, что их названия отображаются
    @Test
    fun displaysProductList() {
        val products = listOf(
            ProductUiModel(1, "Молоко", "89.9", "Свежее"),
            ProductUiModel(2, "Хлеб", "49.9", "Бородинский"),
            ProductUiModel(3, "Сыр", "250.0", "Гауда")
        )

        composeRule.setContent {
            ProductsScreen(uiState = ProductsUiState(products = products))
        }

        composeRule.onNodeWithTag("product_list").assertExists()
        composeRule.onNodeWithText("Молоко").assertIsDisplayed()
        composeRule.onNodeWithText("Хлеб").assertIsDisplayed()
        composeRule.onNodeWithText("Сыр").assertIsDisplayed()
    }

    // TODO 2: Протестируй отображение индикатора загрузки
    // При isLoading = true должен показываться loading_indicator
    @Test
    fun showsLoadingIndicatorWhenIsLoadingIsTrue() {
        composeRule.setContent {
            ProductsScreen(uiState = ProductsUiState(isLoading = true))
        }

        composeRule.onNodeWithTag("loading_indicator").assertIsDisplayed()
    }

    // TODO 3: Протестируй отображение пустого состояния
    // При products = emptyList() и isLoading = false должен показываться empty_state
    @Test
    fun showsEmptyStateWhenProductListIsEmpty() {
        composeRule.setContent {
            ProductsScreen(uiState = ProductsUiState(products = emptyList(), isLoading = false))
        }

        composeRule.onNodeWithTag("empty_state").assertIsDisplayed()
    }

    // TODO 4: Протестируй фильтрацию продуктов через поле поиска
    // Введи текст в search_field и проверь, что отфильтрованные продукты отображаются/скрываются
    @Test
    fun searchFiltersDisplayedProducts() {
        // Arrange: список продуктов и onSearchChanged-колбэк
        val products = listOf(
            ProductUiModel(1, "Молоко", "89.9", ""),
            ProductUiModel(2, "Хлеб", "49.9", "")
        )

        // Act:
        composeRule.setContent {
            var uiState by remember { mutableStateOf(ProductsUiState(products = products)) }
            ProductsScreen(
                uiState = uiState,
                onSearchChanged = { query ->
                    uiState = uiState.copy(
                        searchQuery = query,
                        products = if (query.isBlank()) products
                        else products.filter { it.name.contains(query, ignoreCase = true) }
                    )
                }
            )
        }

        composeRule.onNodeWithTag("search_field").performTextInput("Мол")

        // Assert: "Молоко" отображается, "Хлеб" — нет
        composeRule.onNodeWithText("Молоко").assertIsDisplayed()
        composeRule.onNodeWithText("Хлеб").assertDoesNotExist()
    }

    // TODO 5: Протестируй клик по продукту
    // При клике на продукт должен вызываться onProductClick с правильным id
    @Test
    fun clickingProductCallsOnProductClick() {
        var clickedId = -1

        composeRule.setContent {
            ProductsScreen(
                uiState = ProductsUiState(
                    products = listOf(
                        ProductUiModel(
                            1,
                            "Молоко",
                            "89.9",
                            ""
                        )
                    )
                ),
                onProductClick = { clickedId = it }
            )
        }

        composeRule.onNodeWithTag("product_item_1").performClick()
        assertEquals(1, clickedId)
    }
}