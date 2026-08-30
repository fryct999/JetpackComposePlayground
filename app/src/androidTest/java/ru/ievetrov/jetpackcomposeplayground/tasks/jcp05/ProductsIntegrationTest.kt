package ru.ievetrov.jetpackcomposeplayground.tasks.jcp05

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * JCP-05: Интеграционные тесты репозитория
 *
 * Задание: напиши интеграционные тесты для ProductsRepositoryImpl.
 *
 * Свяжи реальный Room (in-memory) + MockWebServer + репозиторий без моков.
 * Это интеграционный тест — проверяет несколько компонентов вместе.
 *
 * Что нужно протестировать:
 * 1. Успешная загрузка из сети и сохранение в Room DAO
 * 2. Возврат данных из кеша при ошибке сети
 * 3. Очистка кеша (dao становится пустым)
 *
 * ПРИМЕР из урока RCA-51: Интеграционный тест с MockWebServer + Room
 *
 * @Test
 * fun `fetchesProductsAndSavesToDatabase`() = runTest {
 *     // Arrange
 *     val json = """[{"id":1,"name":"Молоко","price":89.9,"description":"Свежее"}]"""
 *     mockWebServer.enqueue(MockResponse().setBody(json).setResponseCode(200))
 *
 *     // Act
 *     val result = repository.loadProducts()
 *
 *     // Assert — данные и в результате, и в DAO
 *     assertTrue(result.isSuccess)
 *     assertTrue(dao.getAllProducts().isNotEmpty())
 * }
 */
@RunWith(AndroidJUnit4::class)
class ProductsIntegrationTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var database: ProductsDatabase
    private lateinit var dao: ProductDao
    private lateinit var repository: ProductsRepositoryImpl

    private val productsJson = """[{"id":1,"name":"Молоко","price":89.9,"description":"Свежее"}]"""

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        mockWebServer = MockWebServer()
        mockWebServer.start()

        database = Room.inMemoryDatabaseBuilder(context, ProductsDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        dao = database.productDao()

        val apiClient = OkHttpProductApiClient(mockWebServer.url("/").toString())
        repository = ProductsRepositoryImpl(apiClient, dao)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
        if (::database.isInitialized) {
            database.close()
        }
    }

    // TODO 1: Протестируй успешную загрузку и сохранение в базу данных
    // MockWebServer отдаёт JSON-список, проверь что данные попали в DAO
    @Test
    fun `fetchesProductsAndSavesToDatabase`() = runTest {
        // Arrange: подготовь JSON и поставь в очередь MockWebServer
        mockWebServer.enqueue(MockResponse().setBody(productsJson).setResponseCode(200))

        val result = repository.loadProducts()

        assertTrue(result.isSuccess)
        assertTrue(dao.getAllProducts().isNotEmpty())
        assertEquals("Молоко", result.getOrThrow().first().name)
    }

    // TODO 2: Протестируй возврат данных из кеша при ошибке сети
    // Сначала загрузи данные (200), потом сделай сервер недоступным (500)
    @Test
    fun `fallsBackToCacheWhenApiUnavailable`() = runTest {
        // Arrange: сначала загружаем данные
        mockWebServer.enqueue(MockResponse().setBody(productsJson).setResponseCode(200))
        val firstResult = repository.loadProducts()

        // "Выключаем" сервер
        mockWebServer.enqueue(MockResponse().setResponseCode(500))

        // Act: повторная загрузка — сервер недоступен
        val cacheResult = repository.loadProducts()

        // Assert: результат успешный (данные из кеша)
        assertTrue(cacheResult.isSuccess)
        assertEquals("Молоко", cacheResult.getOrThrow().first().name)
    }

    // TODO 3: Протестируй очистку кеша
    // После clearCache() DAO должен быть пустым
    @Test
    fun `cacheClearedOnLogout`() = runTest {
        // Arrange: загрузи данные
        mockWebServer.enqueue(MockResponse().setBody(productsJson).setResponseCode(200))
        repository.loadProducts()

        // Act: очисти кеш
        repository.clearCache()

        // Assert: DAO пустой
        assertTrue(dao.getAllProducts().isEmpty())
    }
}
