package ru.ievetrov.jetpackcomposeplayground.tasks.jcp05

import app.cash.turbine.test
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

/**
 * JCP-05: Unit-тесты ViewModel продуктов
 *
 * Задание: напиши unit-тесты для ProductsViewModel.
 *
 * Протестируй поведение ViewModel:
 * 1. Начальное состояние — isLoading = true
 * 2. Успешная загрузка продуктов
 * 3. Ошибка загрузки — error не null
 * 4. Фильтрация по поисковому запросу
 * 5. Добавление в избранное
 *
 * Используй MockK для стаба ProductsRepository и Turbine для проверки StateFlow.
 *
 * ПРИМЕР из урока RCA-49: Тест ViewModel с Turbine
 *
 * @Test
 * fun `loads products successfully`() = runTest {
 *     // Arrange
 *     coEvery { repository.loadProducts() } returns Result.success(fakeProducts)
 *
 *     // Act — ViewModel запускает загрузку в init, ждём корутины
 *     advanceUntilIdle()
 *
 *     // Assert — проверяем через Turbine
 *     viewModel.uiState.test {
 *         val state = awaitItem()
 *         assertFalse(state.isLoading)
 *         assertEquals(3, state.products.size)
 *     }
 * }
 */
@OptIn(ExperimentalCoroutinesApi::class)
class ProductsViewModelTest {
    private val repository: ProductsRepository = mockk(relaxed = true)
    private val testDispatcher = StandardTestDispatcher()

    private lateinit var viewModel: ProductsViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    // TODO 1: Протестируй начальное состояние ViewModel
    // ViewModel в init вызывает loadProducts(), поэтому нужно настроить стаб ДО создания
    @Test
    fun `initial state shows loading`() = runTest(testDispatcher) {
        coEvery { repository.loadProducts() } returns Result.success(emptyList())
        //coEvery { repository.loadProducts() } coAnswers { delay(1000); Result.success(emptyList()) }
        viewModel = ProductsViewModel(repository)
        assertEquals(true, viewModel.uiState.value.isLoading)
    }

    // TODO 2: Протестируй успешную загрузку продуктов
    // Проверь, что после загрузки isLoading = false и список не пуст
    @Test
    fun `loads products successfully`() = runTest(testDispatcher) {
        val fakeProducts = listOf(
            ProductUiModel(1, "Молоко", "89.9", ""),
            ProductUiModel(2, "Хлеб", "49.5", ""),
        )

        coEvery { repository.loadProducts() } returns Result.success(fakeProducts)

        viewModel = ProductsViewModel(repository)
        advanceUntilIdle()

        viewModel.uiState.test {
            //val initialState = awaitItem()  // isLoading = true
            val state = awaitItem()   // isLoading = false, products не пуст
            assertFalse(state.isLoading)
            assertEquals(2, state.products.size)
        }
    }

    // TODO 3: Протестируй ошибку загрузки
    // Проверь, что при ошибке: isLoading = false, error не null
    @Test
    fun `handles load error`() = runTest(testDispatcher) {
        coEvery { repository.loadProducts() } returns Result.failure(RuntimeException("Сетевая ошибка"))

        viewModel = ProductsViewModel(repository)
        advanceUntilIdle()

        viewModel.uiState.test {
            val state = awaitItem()
            assertFalse(state.isLoading)
            assertFalse(state.error.isNullOrEmpty())
        }
    }

    // TODO 4: Протестируй фильтрацию по поисковому запросу
    // После загрузки вызови onSearchChanged("Мол") — в списке должен остаться только "Молоко"
    @Test
    fun `search filters products`() = runTest(testDispatcher) {
        val fakeProducts = listOf(
            ProductUiModel(1, "Молоко", "89.9", ""),
            ProductUiModel(2, "Хлеб", "49.5", ""),
            ProductUiModel(3, "Масло", "149.5", ""),
        )

        coEvery { repository.loadProducts() } returns Result.success(fakeProducts)

        viewModel = ProductsViewModel(repository)
        advanceUntilIdle()

        viewModel.uiState.test {
            awaitItem()
            viewModel.onSearchChanged("Мол")
            val state = expectMostRecentItem()
            assertEquals(1, state.products.size)
            assertTrue(state.products[0].name.contains("Молоко"))
        }
    }

    // TODO 5: Протестируй добавление в избранное
    // Проверь с помощью awaitItem() что state обновился немедленно
    @Test
    fun `adding to favorites updates state`() = runTest(testDispatcher) {
        val fakeProducts = listOf(
            ProductUiModel(1, "Молоко", "89.9", ""),
            ProductUiModel(2, "Хлеб", "49.5", ""),
            ProductUiModel(3, "Масло", "149.5", ""),
        )

        coEvery { repository.loadProducts() } returns Result.success(fakeProducts)

        viewModel = ProductsViewModel(repository)
        advanceUntilIdle()

        viewModel.uiState.test {
            awaitItem()
            viewModel.addToFavorites(productId = 1)
            val state = awaitItem()
            assertTrue(state.favorites.contains(1))
        }
    }
}