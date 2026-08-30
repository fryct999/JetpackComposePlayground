package ru.ievetrov.jetpackcomposeplayground.tasks.jcp05

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import ru.ievetrov.jetpackcomposeplayground.tasks.jcp05.ProductMapper.map
import ru.ievetrov.jetpackcomposeplayground.tasks.jcp05.ProductMapper.mapList

/**
 * JCP-05: Unit-тесты маппера продуктов
 *
 * Задание: напиши unit-тесты для ProductMapper.
 *
 * Протестируй все методы маппера:
 * 1. Маппинг одного DTO со всеми заполненными полями
 * 2. Маппинг DTO с null-ценой
 * 3. Маппинг DTO с null-описанием
 * 4. Маппинг списка DTO
 * 5. Маппинг пустого списка
 *
 * ПРИМЕР из урока RCA-47: AAA-структура теста
 *
 * @Test
 * fun `maps DTO to UI model correctly`() {
 *     // Arrange
 *     val dto = ProductDto(id = 1, name = "Молоко", price = 89.90, description = "Свежее")
 *
 *     // Act
 *     val result = ProductMapper.map(dto)
 *
 *     // Assert
 *     assertEquals(1, result.id)
 *     assertEquals("Молоко", result.name)
 *     assertEquals("89.9", result.price)
 *     assertEquals("Свежее", result.description)
 * }
 */
class ProductMapperTest {
    // TODO 1: Протестируй маппинг одного DTO со всеми полями
    // Убедись, что id, name, price, description маппятся правильно
    @Test
    fun `maps DTO to UI model correctly`() {
        val dto = ProductDto(
            id = 1,
            name = "Name",
            price = 100.0,
            description = "Description",
        )

        val uiModel = map(dto)

        assertEquals(1, uiModel.id)
        assertEquals("Name", uiModel.name)
        assertEquals("100.0", uiModel.price)
        assertEquals("Description", uiModel.description)
    }

    // TODO 2: Протестируй обработку null-цены
    // Ожидается: price = "Цена не указана"
    @Test
    fun `handles null price`() {
        val dto = ProductDto(
            id = 1,
            name = "Name",
            price = null,
            description = "Description",
        )

        val uiModel = map(dto)

        assertEquals("Цена не указана", uiModel.price)
    }

    // TODO 3: Протестируй обработку null-описания
    // Ожидается: description = ""
    @Test
    fun `handles null description`() {
        val dto = ProductDto(
            id = 1,
            name = "Name",
            price = null,
            description = null,
        )

        val uiModel = map(dto)

        assertEquals("", uiModel.description)
    }

    // TODO 4: Протестируй маппинг списка из 3 DTO
    // Убедись, что размер результата = 3, и элементы маппятся верно
    @Test
    fun `maps list of DTOs correctly`() {
        val dtoList = listOf(
            ProductDto(1, "Продукт 1", 1.0, "Описание 1"),
            ProductDto(2, "Продукт 2", 2.0, "Описание 2"),
            ProductDto(3, "Продукт 3", 3.0, "Описание 3"),
        )

        val uiModelList = mapList(dtoList)

        assertEquals(3, uiModelList.size)
        assertEquals(1, uiModelList[0].id)
        assertEquals("Продукт 1", uiModelList[0].name)
        assertEquals(2, uiModelList[1].id)
        assertEquals("Продукт 2", uiModelList[1].name)
        assertEquals(3, uiModelList[2].id)
        assertEquals("Продукт 3", uiModelList[2].name)
    }

    // TODO 5: Протестируй маппинг пустого списка
    // Ожидается: пустой список
    @Test
    fun `handles empty list`() {
        val dtoList: List<ProductDto> = emptyList()
        val uiModelList = mapList(dtoList)
        assertTrue(uiModelList.isEmpty())
    }
}
